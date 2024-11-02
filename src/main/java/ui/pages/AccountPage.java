package ui.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public static final By PROFILE_TAB = By.xpath(".//a[contains(text(), 'рофиль')]");
    public static final By EXIT_BUTTON = By.xpath(".//button[contains(text(), 'ыход')]");

    @Step("Check profile tab is displayed")
    public static void checkProfileTabDisplayed(AccountPage accountPage) {
        Assert.assertTrue("Profile tab not visible on account page", accountPage.isProfileTabDisplayed());
    }

    @Step("Click exit button")
    public void clickExitButton() {
        driver.findElement(EXIT_BUTTON).click();
    }

    @Step("Check if profile is displayed")
    public boolean isProfileTabDisplayed() {
        return driver.findElement(PROFILE_TAB).isDisplayed();
    }

}
