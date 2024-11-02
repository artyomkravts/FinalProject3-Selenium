package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public static final String FORGOT_PASSWORD_PAGE_URL = BASE_URI + "/forgot-password";

    public static final By LOG_IN_BUTTON = By.cssSelector("a[href='/login']");

    @Step("Click login button")
    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }
}
