package ui.pages;

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

    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    public boolean isBunsTabVisible() {
        WebElement bunsTab = driver.findElement(BUNS_TAB);
        return bunsTab.isDisplayed();
    }
}
