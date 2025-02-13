package uiTests;

import api.UserClient;
import api.requestPOJOs.LoginUser;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ui.DataGenerator;
import utils.DriverFactory;
import ui.pages.LoginPage;
import ui.pages.RegisterPage;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseAuthTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        LoginUser loginUser = new LoginUser(testEmail, testPassword);

        Response response = UserClient.logInUser(loginUser);

        accessToken = UserClient.getAccessTokenWithoutBearer(response);

        super.tearDown();
    }

    String testName;
    String testEmail;
    String testPassword;
    boolean isTestPositive;

    public RegisterTest(String testName, String testEmail, String testPassword, boolean isTestPositive) {
        this.testName = testName;
        this.testEmail = testEmail;
        this.testPassword = testPassword;
        this.isTestPositive = isTestPositive;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(6), true},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(5), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(1), false},
            {DataGenerator.getRandomValidFirstName(), DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(0), false},
            {"", DataGenerator.getRandomValidEmail(), DataGenerator.getRandomPassword(7), false},
            {DataGenerator.getRandomValidFirstName(), "", DataGenerator.getRandomPassword(7), false},
        };
    }

    @Test
    public void registerParameterizedTest() {
        driver = driverFactory.getDriver();

        driver.get(RegisterPage.REGISTER_PAGE_URL);

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.fillName(testName);
        registerPage.fillEmail(testEmail);
        registerPage.fillPassword(testPassword);

        registerPage.clickRegisterButton();


        if (isTestPositive) {
            registerPage.waitFiveSecUntilUrlToBe(LoginPage.LOGIN_PAGE_URL);
            registerPage.checkCurrentUrl(LoginPage.LOGIN_PAGE_URL);
        } else {
            registerPage.waitFiveSecUntilUrlToBe(RegisterPage.REGISTER_PAGE_URL);
            registerPage.checkCurrentUrl(RegisterPage.REGISTER_PAGE_URL);
        }

    }

}
