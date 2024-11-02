package uiTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import ui.pages.*;

public class LoginTest extends BaseAuthTest {
    @Test
    @DisplayName("Login from main page (login button) with valid creds successful")
    public void loginFromMainPageLoginButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }

    @Test
    @DisplayName("Login from main page (personal account button) with valid creds successful")
    public void loginFromMainPagePersonalAccountButtonValidCredsSuccessful() {
        MainPage mainPage = new MainPage(driver);

        driver.get(MainPage.MAIN_PAGE_URL);

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }

    @Test
    @DisplayName("Login from register page with valid creds successful")
    public void loginFromRegisterPageLoginButtonValidCredsSuccessful() {
        RegisterPage registerPage = new RegisterPage(driver);

        driver.get(RegisterPage.REGISTER_PAGE_URL);

        registerPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage mainPage = new MainPage(driver);

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }

    @Test
    @DisplayName("Login from forgot password page with valid creds successful")
    public void loginFromForgotPasswordPageLoginButtonValidCredsSuccessful() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        driver.get(ForgotPasswordPage.FORGOT_PASSWORD_PAGE_URL);

        forgotPasswordPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(email, password);

        MainPage mainPage = new MainPage(driver);

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }


}
