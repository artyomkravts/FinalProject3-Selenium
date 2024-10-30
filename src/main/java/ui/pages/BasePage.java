package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String BASE_URI = ConfigReader.getProperty("base.uri");

    public static final By CONSTRUCTOR_BUTTON = By.cssSelector("a.AppHeader_header__link__3D_hX[href='/']");
    public static final By STELLAR_BURGERS_LOGO = By.cssSelector("div.AppHeader_header__logo__2D0X2");

    @Step("Click constructor button")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    @Step("Click logo")
    public void clickLogo() {
        driver.findElement(STELLAR_BURGERS_LOGO).click();
    }
    @Step("Wait 10 sec until element is displayed")
    public void waitTenSecUntilDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
