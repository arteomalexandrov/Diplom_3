import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    @Before
    public void setupAndLaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void goToBunsTest() {
        homePage.clickSauceLink();
        homePage.clickBunsLink();
        Assert.assertTrue(homePage.bunsTextIsDisplayed());
    }

    @Test
    public void goToSauceTest() {
        homePage.clickSauceLink();
        Assert.assertTrue(homePage.sauceTextIsDisplayed());
    }

    @Test
    public void goToFillingsTest() {
        homePage.clickFillingsLink();
        Assert.assertTrue(homePage.fillingsTextIsDisplayed());
    }

    @Test
    public void goToConstructorByClickButtonTest() {
        homePage.clickOrdersListButton();
        homePage.clickConstructorButton();

        Assert.assertTrue(homePage.buildBurgerTextIsDisplayed());
    }

    @Test
    public void goToConstructorByClickLogoTest() {
        homePage.clickOrdersListButton();
        homePage.clickToLogo();

        Assert.assertTrue(homePage.buildBurgerTextIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
