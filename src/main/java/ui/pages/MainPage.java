package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    public static final By BUNS_TAB = By.xpath("//span[contains(text(), \"Булки\")]");
    public static final By LOG_IN_BUTTON = By.xpath("//button[contains(text(), 'Войти в аккаунт')]");
    public static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[text()='Личный Кабинет']");

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
