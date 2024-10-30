package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static final String REGISTRATION_PAGE_URL = BASE_URI + "/register";

    private static final By NAME_FIELD = By.xpath("(.//*[@class='text input__textfield text_type_main-default'])[1]");
    private static final By EMAIL_FIELD = By.xpath("(.//*[@class='text input__textfield text_type_main-default'])[2]");
    private static final By PASSWORD_FIELD = By.xpath(".//*[@class='text input__textfield text_type_main-default' and contains(@name, 'ароль')]");
    private static final By REGISTER_BUTTON = By.xpath(".//button[contains(text(), 'регистр')]");
    private static final By LOG_IN_BUTTON = By.cssSelector("a[href=\"/login\"]");

    @Step("Fill name field")
    public void fillName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }
    @Step("Fill email field")
    public void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    @Step("Fill password field")
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    @Step("Click register button")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    @Step("Click login button")
    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }
}
