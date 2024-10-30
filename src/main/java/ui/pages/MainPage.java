package ui.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String MAIN_PAGE_URL = BASE_URI;

    public static final By BUNS_TAB = By.xpath(".//span[contains(text(), 'улки')]/..");
    public static final By CHOSEN_TAB = By.cssSelector("div.tab_tab_type_current__2BEPc ");
    public static final By SAUCES_TAB = By.xpath(".//span[contains(text(), 'оусы')]/..");
    public static final By FILLINGS_TAB = By.xpath(".//span[contains(text(), 'ачинки')]/..");
    public static final By SPAN_TAG = By.xpath(".//span"); // здесь лежит текст табов ^
    public static final By LOG_IN_BUTTON = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    public static final By PERSONAL_ACCOUNT_BUTTON = By.cssSelector("a.AppHeader_header__link__3D_hX[href='/account']");

    @Step("Check chosen tab is sauces")
    public static void checkChosenTabIsSauces(WebElement element) {
        Assert.assertEquals("The text of the span should be 'Соусы'", "Соусы", element.getText());
    }

    @Step("Check chosen tab is fillings")
    public static void checkChosenTabIsFillings(WebElement element) {
        Assert.assertEquals("The text of the span should be 'Начинки'", "Начинки", element.getText());
    }
    @Step("Check chosen tab is buns")
    public static void checkChosenTabIsBuns(WebElement element) {
        Assert.assertEquals("The text of the span should be 'Булки'", "Булки", element.getText());
    }

    @Step("Check buns tab is visible on main page")
    public static void checkBunsTabIsDisplayed(MainPage mainPage) {
        Assert.assertTrue("Buns tab not visible on main page" , mainPage.isBunsTabDisplayed());
    }

    @Step("Click login button")
    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    @Step("Click personal account button")
    public void clickPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Check if buns tab is displayed")
    public boolean isBunsTabDisplayed() {
        WebElement bunsTab = driver.findElement(BUNS_TAB);
        return bunsTab.isDisplayed();
    }

}
