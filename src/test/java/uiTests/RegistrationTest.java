package uiTests;

import api.UserClient;
import api.requestPOJOs.LoginUser;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.DataGenerator;
import ui.pages.LoginPage;
import ui.pages.RegistrationPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class RegistrationTest {
    WebDriver driver = new ChromeDriver();

    String testName;
    String testEmail;
    String testPassword;
    boolean isTestPositive;

    public RegistrationTest(String testName, String testEmail, String testPassword, boolean isTestPositive) {
        this.testName = testName;
        this.testEmail = testEmail;
        this.testPassword = testPassword;
        this.isTestPositive = isTestPositive;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(15), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(6), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(5), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(1), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(0), false},
            {"", DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), false},
            {DataGenerator.getRandomValidFirstName(), "", DataGenerator.getRandomPassword(7), false},
        };
    }

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(RegistrationPage.REGISTRATION_PAGE_URL);
    }
    @After
    public void tearDown() {
        LoginUser loginUser = new LoginUser(testEmail, testPassword);

        Response response = UserClient.logInUser(loginUser);

        String accessToken = UserClient.getAccessTokenWithoutBearer(response);

        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }

        driver.quit();
    }

    @Test
    public void registrationParameterizedTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.fillName(testName);
        registrationPage.fillEmail(testEmail);
        registrationPage.fillPassword(testPassword);

        registrationPage.clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (isTestPositive) {
            wait.until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));
            Assert.assertEquals("The URL is unexpected", LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
        } else {
            wait.until(ExpectedConditions.urlToBe(RegistrationPage.REGISTRATION_PAGE_URL));
            Assert.assertEquals("The URL is unexpected", RegistrationPage.REGISTRATION_PAGE_URL, driver.getCurrentUrl());
        }

    }

}
