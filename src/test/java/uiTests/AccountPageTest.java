package uiTests;

import org.junit.Before;
import org.junit.Test;
import ui.pages.AccountPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

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

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }

    @Test
    public void clickLogoFromAccountPageSuccessful() {
        accountPage.waitTenSecUntilDisplayed(AccountPage.STELLAR_BURGERS_LOGO);
        accountPage.clickLogo();

        MainPage mainPage = new MainPage(driver);

        MainPage.checkBunsTabIsDisplayed(mainPage);
    }

    @Test
    public void clickExitButtonSuccessful() {
        accountPage.waitTenSecUntilDisplayed(AccountPage.EXIT_BUTTON);
        accountPage.clickExitButton();

        accountPage.waitFiveSecUntilUrlToBe(LoginPage.LOGIN_PAGE_URL);

        accountPage.checkCurrentUrl(LoginPage.LOGIN_PAGE_URL);

    }

}
