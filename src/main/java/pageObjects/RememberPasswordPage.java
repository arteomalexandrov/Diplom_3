package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RememberPasswordPage {
    private final WebDriver driver;

    private final By emailTextField = By.xpath(".//fieldset/div/div/input");

    private final By loginLink = By.xpath(".//a[text() = 'Войти']");

    private final By rememberButton = By.xpath(".//button[text() = 'Восстановить']");

    public RememberPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rememberPassword(String email) {
        driver.findElement(emailTextField).click();
        fillEmailField(email);
        clickRememberButton();
    }

    public void fillEmailField(String email) {
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickRememberButton() {
        driver.findElement(rememberButton).click();
    }

}
