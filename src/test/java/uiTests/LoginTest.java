package uiTests;

import api.UserClient;
import api.requestPOJOs.RegisterUser;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.DataGenerator;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    String testEmail;
    String testPassword;
    String accessToken;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        testEmail = DataGenerator.getRandomValidEmail();
        testPassword = DataGenerator.getRandomPassword(10);
        RegisterUser user = new RegisterUser(testEmail, testPassword, DataGenerator.getRandomValidFirstName());

        Response response = UserClient.registerUser(user);
        accessToken = UserClient.getAccessTokenWithoutBearer(response);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
        driver.quit();
    }

    @Test
    public void loginFromMainPageLoginButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(testEmail, testPassword);

        Assert.assertTrue(mainPage.isBunsTabVisible());

    }
}
