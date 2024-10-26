package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By NAME_FIELD = By.xpath("(//*[@class='text input__textfield text_type_main-default'])[1]");
    private static final By EMAIL_FIELD = By.xpath("(//*[@class='text input__textfield text_type_main-default'])[2]");
    private static final By PASSWORD_FIELD = By.xpath("//*[@class='text input__textfield text_type_main-default' and contains(@name, 'ароль')]");
    private static final By REGISTER_BUTTON = By.xpath("//button[contains(text(), 'регистр')]");

    public void fillName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }
    public void fillEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
}
