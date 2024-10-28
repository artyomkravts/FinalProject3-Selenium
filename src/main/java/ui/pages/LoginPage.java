package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    public static final By PASSWORD_FIELD = By.cssSelector("input[type=password]");
    public static final By EMAIL_FIELD = By.xpath("//input[@class=\"text input__textfield text_type_main-default\" and @type=\"text\"]");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), \"Войти\")]");

    public void logIn(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickLoginButton();
    }

    public void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}