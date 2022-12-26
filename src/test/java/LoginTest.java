import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.RememberPasswordPage;
import user.User;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private RememberPasswordPage rememberPasswordPage;
    private HomePage homePage;
    @Before
    public void setupAndLaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        rememberPasswordPage = new RememberPasswordPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void goToLoginAndLoginIn() {
        homePage.clickLoginInButton();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.orderButtonIsDisplayed());
    }

    @Test
    public void goToLoginByAccountButtonAndLoginIn() {
        homePage.clickAccountButton();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.orderButtonIsDisplayed());
    }

    @Test
    public void goToLoginFromRegistrationFormAndLoginIn() {
        homePage.clickLoginInButton();
        loginPage.clickRegistrationLink();
        registerPage.clickLinkEnter();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.orderButtonIsDisplayed());

    }

    @Test
    public void goToLoginFromRememberPasswordPageAndLoginIn() {
        homePage.clickLoginInButton();
        loginPage.clickRememberPasswordLink();
        rememberPasswordPage.clickLoginLink();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.orderButtonIsDisplayed());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
