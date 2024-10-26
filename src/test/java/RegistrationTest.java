import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTest {
    WebDriver driver = new ChromeDriver();

    String testName = RandomStringUtils.randomAlphabetic(4, 12);
    String testEmail = RandomStringUtils.randomAlphabetic(6) + "@test.ru";
    String testPassword = RandomStringUtils.randomAlphabetic(6);

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationValidDataSuccessful() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.fillName(testName);
        registrationPage.fillEmail(testEmail);
        registrationPage.fillPassword(testPassword);

        registrationPage.clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        Assert.assertEquals("The URL is unexpected", "https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }


}
