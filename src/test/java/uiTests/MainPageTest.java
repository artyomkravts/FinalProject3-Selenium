package uiTests;

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
    public void clickPersonalAccountFromMainPageSuccessful() {
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);

        mainPage.clickPersonalAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        Assert.assertTrue(accountPage.isProfileTabDisplayed());
    }

    @Test
    public void clickSauceTabWorks () throws InterruptedException {
        driver.findElement(MainPage.SAUCES_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        Assert.assertEquals("The text of the span should be 'Соусы'", "Соусы", child.getText());
    }
    @Test
    public void clickFillingsTabWorks () {
        driver.findElement(MainPage.FILLINGS_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        Assert.assertEquals("The text of the span should be 'Начинки'", "Начинки", child.getText());
    }
    @Test
    public void clickBunTabWorks () {
        driver.findElement(MainPage.SAUCES_TAB).click();
        driver.findElement(MainPage.BUNS_TAB).click();

        WebElement parent = driver.findElement(MainPage.CHOSEN_TAB);
        WebElement child = parent.findElement(MainPage.SPAN_TAG);
        Assert.assertEquals("The text of the span should be 'Булки'", "Булки", child.getText());
    }
}
