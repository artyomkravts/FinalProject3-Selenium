package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Getter
public class DriverFactory extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        switch (ConfigReader.getProperty("browser")) {
            case "firefox":
                initFireFox();
                break;
            case "chrome":
                initChrome();
                break;
            case "yandex":
                initYandex();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }
    public void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void initFireFox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void initYandex() {
        WebDriverManager.chromedriver().driverVersion(ConfigReader.getProperty("driver.version")).setup();

        var options = new ChromeOptions();
        options.setBinary(ConfigReader.getProperty("webdriver.yandex.exe.path"));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
