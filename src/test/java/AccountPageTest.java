import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import user.User;

import java.util.concurrent.TimeUnit;

public class AccountPageTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Before
    public void setupAndLaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);

    }

    @Test
    public void enterToAccountPageTest() {
        homePage.clickAccountButton();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();
        homePage.clickAccountButton();

        Assert.assertTrue(accountPage.exitButtonIsDisplayed());
    }


    @Test
    public void exitFromAccountTest() {
        homePage.clickLoginInButton();

        loginPage.WaitLoadingPage();
        loginPage.fillLoginForm(User.getDefaultUser());
        loginPage.clickLoginButton();
        homePage.clickAccountButton();
        accountPage.clickExitButton();

        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
