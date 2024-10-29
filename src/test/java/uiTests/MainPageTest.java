package uiTests;

import org.junit.*;
import ui.pages.AccountPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

public class MainPageTest extends BaseTest {
    @Before
    public void setUp() {
        super.setUp();
        driver.get(MainPage.MAIN_PAGE_URL);
    }
    @Test
    public void clickPersonalAccountFromMainPageSuccessful() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);

        mainPage.clickPersonalAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        Assert.assertTrue(accountPage.isProfileTabDisplayed());
    }
}
