package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private static final By LOG_IN_BUTTON = By.cssSelector("a[href=\"/login\"]");

    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }
}
