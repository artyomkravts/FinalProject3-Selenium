package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String LOGIN_PAGE_URL = BASE_URI + "/login";

    public static final By PASSWORD_FIELD = By.cssSelector("input[type=password]");
    public static final By EMAIL_FIELD = By.xpath(".//input[@class=\"text input__textfield text_type_main-default\" and @type=\"text\"]");
    public static final By LOGIN_BUTTON = By.xpath(".//button[contains(text(), 'Войти')]");

    @Step("Log in")
    public void logIn(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickLoginButton();
    }

    @Step("Fill email")
    public void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    @Step("Fill password")
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
