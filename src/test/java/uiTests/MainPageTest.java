package uiTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebElement;
import ui.pages.AccountPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

public class MainPageTest extends BaseAuthTest {
    private MainPage mainPage;
    @Before
    public void setUp() {
        super.setUp();
        driver.get(MainPage.MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
    }
    @Test
    @DisplayName("Can open personal account from main page")
    public void clickPersonalAccountProfileTabDisplayed() {
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);

        mainPage.clickPersonalAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        accountPage.waitTenSecUntilDisplayed(AccountPage.PROFILE_TAB);

        AccountPage.checkProfileTabDisplayed(accountPage);
    }

    @Test
    @DisplayName("Click sauce tab successful")
    public void clickSauceTabWorks () {
        driver.findElement(MainPage.SAUCES_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        MainPage.checkChosenTabIsSauces(child);
    }

    @Test
    @DisplayName("Click fillings tab successful")
    public void clickFillingsTabWorks () {
        driver.findElement(MainPage.FILLINGS_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        MainPage.checkChosenTabIsFillings(child);
    }

    @Test
    @DisplayName("Click bun tab successful")
    public void clickBunTabWorks () {
        driver.findElement(MainPage.SAUCES_TAB).click();
        driver.findElement(MainPage.BUNS_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        MainPage.checkChosenTabIsBuns(child);
    }

}
