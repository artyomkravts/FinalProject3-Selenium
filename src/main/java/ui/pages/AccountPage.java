package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By PROFILE_TAB = By.xpath(".//a[contains(text(), 'рофиль')]");
    public static final By EXIT_BUTTON = By.xpath(".//button[contains(text(), 'ыход')]");
    public static final By CONSTRUCTOR_BUTTON = By.cssSelector("a.AppHeader_header__link__3D_hX[href='/']");
    public static final By STELLAR_BURGERS_LOGO = By.cssSelector("a[class='active']");

    public void clickExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void clickLogo() {
        driver.findElement(STELLAR_BURGERS_LOGO).click();
    }

    public boolean isProfileTabDisplayed() {
        return driver.findElement(PROFILE_TAB).isDisplayed();
    }

}
