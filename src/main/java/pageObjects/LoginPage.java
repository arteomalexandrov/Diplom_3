package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By emailTextField = By.xpath(".//fieldset[1]/div/div/input");

    private final By passwordTextField = By.xpath(".//fieldset[2]/div/div/input");

    private final By loginButton = By.xpath(".//button[text() = 'Войти']");

    private final By registrationLink = By.linkText("Зарегистрироваться");

    //Ссылка "Восстановить пароль"
    private final By rememberPasswordLink = By.xpath(".//a[text() = 'Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(User user) {
        clickEmailTextField();
        fillEmailTextField(user.getEmail());
        clickPasswordTextField();
        fillPasswordTextField(user.getPassword());
    }

    public void WaitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10));
        ExpectedConditions.visibilityOfElementLocated(loginButton);
    }

    public void clickEmailTextField() {
        driver.findElement(emailTextField).click();
    }

    public void fillEmailTextField(String email) {
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void clickPasswordTextField() {
        driver.findElement(passwordTextField).click();
    }

    public void fillPasswordTextField(String password) {
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    public void clickRememberPasswordLink() {
        driver.findElement(rememberPasswordLink).click();
    }


}
