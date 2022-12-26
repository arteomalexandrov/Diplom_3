import api.UserApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import user.Identity;
import user.User;

import java.util.concurrent.TimeUnit;

public class RegisterPageTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private final UserApi api = new UserApi();

    @Before
    public void setupAndLaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void registrationTest() {
        homePage.clickLoginInButton();

        loginPage.clickRegistrationLink();

        User user = new User("newMail@mail.ru","123456","newName");
        registerPage.fillRegistrationForm(user);
        registerPage.clickRegisteredButton();

        loginPage.WaitLoadingPage();

        ValidatableResponse response = api.login(new Identity(user));
        String token = response.extract().path("accessToken").toString().split("Bearer ")[1];

        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
        api.deleteUser(token);
    }


    @Test
    public void invalidPasswordRegistrationTest() {
        homePage.clickLoginInButton();
        loginPage.clickRegistrationLink();

        registerPage.fillRegistrationForm(new User("defaultMail@mail.ru", "12345", "defaultName"));
        registerPage.clickRegisteredButton();

        Assert.assertTrue(registerPage.invalidPasswordMessageIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
