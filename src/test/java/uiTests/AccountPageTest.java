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

public class AccountPageTest extends BaseAuthTest {
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
        accountPage.waitTenSecUntilDisplayed(AccountPage.CONSTRUCTOR_BUTTON);
        accountPage.clickConstructorButton();

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue("Buns tab not visible on main page" ,mainPage.isBunsTabDisplayed());
    }

    @Test
    public void clickLogoFromAccountPageSuccessful() {
        accountPage.waitTenSecUntilDisplayed(AccountPage.STELLAR_BURGERS_LOGO);
        accountPage.clickLogo();

        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue("Buns tab not visible on main page" ,mainPage.isBunsTabDisplayed());
    }

    @Test
    public void clickExitButtonSuccessful() {
        accountPage.waitTenSecUntilDisplayed(AccountPage.EXIT_BUTTON);
        accountPage.clickExitButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(LoginPage.LOGIN_PAGE_URL));

        Assert.assertEquals("The page URL didn't switch to /login" ,LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

}
