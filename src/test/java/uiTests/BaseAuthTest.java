package uiTests;

import api.UserClient;
import api.requestPOJOs.RegisterUser;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.DataGenerator;
import utils.DriverFactory;

import java.time.Duration;

public abstract class BaseAuthTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    WebDriver driver;

    String email;
    String password;
    String accessToken;

    @Before
    public void setUp() {
        driver = driverFactory.getDriver();

        email = DataGenerator.getRandomValidEmail();
        password = DataGenerator.getRandomPassword(10);
        RegisterUser user = new RegisterUser(email, password, DataGenerator.getRandomValidFirstName());

        Response response = UserClient.registerUser(user);
        accessToken = UserClient.getAccessTokenWithoutBearer(response);
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        } else System.out.println("Пользователь не был удалён!");
    }
}
