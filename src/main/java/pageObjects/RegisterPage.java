package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class RegisterPage {
    private final WebDriver driver;

    //Поле "Имя"
    private final By nameTextField = By.xpath(".//fieldset[1]/div/div/input");

    //Поле "Email"
    private final By emailTextField = By.xpath(".//fieldset[2]/div/div/input");

    //Поле "Пароль"
    private final By passwordTextField = By.xpath(".//fieldset[3]/div/div/input");

    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    //Ссылка "Войти"
    private final By loginLink = By.xpath(".//a[text() = 'Войти']");

    // Текст "Некорректный пароль"
    private final By invalidPasswordMessage = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillRegistrationForm(User user) {
        fillNameField(user.getName());
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
    }

    public void fillNameField(String name) {
        driver.findElement(nameTextField).sendKeys(name);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void clickRegisteredButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLinkEnter() {
        driver.findElement(loginLink).click();
    }

    public boolean invalidPasswordMessageIsDisplayed() {
        return driver.findElement(invalidPasswordMessage).isDisplayed();
    }

}
