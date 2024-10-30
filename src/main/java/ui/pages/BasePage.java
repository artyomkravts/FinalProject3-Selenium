package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected static final String BASE_URI = ConfigReader.getProperty("base.uri");

    protected static final By CONSTRUCTOR_BUTTON = By.cssSelector("a.AppHeader_header__link__3D_hX[href='/']");
    protected static final By STELLAR_BURGERS_LOGO = By.cssSelector("a[class='active']");

    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void clickLogo() {
        driver.findElement(STELLAR_BURGERS_LOGO).click();
    }

}
