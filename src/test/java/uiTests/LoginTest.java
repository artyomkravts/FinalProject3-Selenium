package uiTests;

import api.UserClient;
import api.requestPOJOs.RegisterUser;
import io.restassured.response.Response;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import ui.DataGenerator;
import utils.DriverFactory;
import ui.pages.ForgotPasswordPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.RegisterPage;

import java.time.Duration;

public class LoginTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    WebDriver driver;

    String testEmail;
    String testPassword;
    String accessToken;

    @Before
    public void setUp() {
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

    @Test
    public void loginFromMainPagePrivateAccountButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(testEmail, testPassword);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void loginFromRegisterPageLoginButtonValidCredsSuccessful() {
        RegisterPage registerPage = new RegisterPage(driver);

        driver.get(RegisterPage.REGISTRATION_PAGE_URL);

        registerPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(testEmail, testPassword);

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void loginFromForgotPasswordPageLoginButtonValidCredsSuccessful() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        driver.get(ForgotPasswordPage.FORGOT_PASSWORD_PAGE_URL);

        forgotPasswordPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(testEmail, testPassword);

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }


}
