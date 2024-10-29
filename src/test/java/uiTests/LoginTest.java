package uiTests;

import api.UserClient;
import api.requestPOJOs.RegisterUser;
import io.restassured.response.Response;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import ui.DataGenerator;
import ui.pages.*;
import utils.DriverFactory;

public class LoginTest extends BaseTest {
    @Test
    public void loginFromMainPageLoginButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void loginFromMainPagePrivateAccountButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void loginFromRegisterPageLoginButtonValidCredsSuccessful() {
        RegisterPage registerPage = new RegisterPage(driver);

        driver.get(RegisterPage.REGISTRATION_PAGE_URL);

        registerPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void loginFromForgotPasswordPageLoginButtonValidCredsSuccessful() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        driver.get(ForgotPasswordPage.FORGOT_PASSWORD_PAGE_URL);

        forgotPasswordPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }


}
