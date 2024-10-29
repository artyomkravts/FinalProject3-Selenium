package uiTests;

import api.UserClient;
import api.requestPOJOs.LoginUser;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.DataGenerator;
import ui.DriverFactory;
import ui.pages.LoginPage;
import ui.pages.RegisterPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class RegisterTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        LoginUser loginUser = new LoginUser(testEmail, testPassword);

        Response response = UserClient.logInUser(loginUser);

        String accessToken = UserClient.getAccessTokenWithoutBearer(response);

        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
        // driver.quit() -- наследуется через @Rule
    }

    String testName;
    String testEmail;
    String testPassword;
    boolean isTestPositive;

    public RegisterTest(String testName, String testEmail, String testPassword, boolean isTestPositive) {
        this.testName = testName;
        this.testEmail = testEmail;
        this.testPassword = testPassword;
        this.isTestPositive = isTestPositive;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(6), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(5), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(1), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(0), false},
            {"", DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), false},
            {DataGenerator.getRandomValidFirstName(), "", DataGenerator.getRandomPassword(7), false},
        };
    }

    @Test
    public void registerParameterizedTest() {
        WebDriver driver = driverFactory.getDriver();

        driver.get(RegisterPage.REGISTRATION_PAGE_URL);

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillName(testName);
        registerPage.fillEmail(testEmail);
        registerPage.fillPassword(testPassword);

        registerPage.clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (isTestPositive) {
            wait.until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));
            Assert.assertEquals("The URL is unexpected", LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
        } else {
            wait.until(ExpectedConditions.urlToBe(RegisterPage.REGISTRATION_PAGE_URL));
            Assert.assertEquals("The URL is unexpected", RegisterPage.REGISTRATION_PAGE_URL, driver.getCurrentUrl());
        }

    }

}
