package uiTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.AccountPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import java.time.Duration;

public class AccountPageTest extends BaseTest {
    private AccountPage accountPage;
    @Before
    public void setUp() {
        super.setUp();
        driver.get(MainPage.MAIN_PAGE_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);

        mainPage.clickPersonalAccountButton();
        accountPage = new AccountPage(driver);
    }

    @Test
    public void clickConstructorFromAccountPageSuccessful() {
        accountPage.clickConstructorButton();

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void clickLogoFromAccountPageSuccessful() {
        accountPage.clickLogo();

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isBunsTabVisible());
    }

    @Test
    public void clickExitButtonSuccessful() {
        accountPage.clickExitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));

        Assert.assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

}
