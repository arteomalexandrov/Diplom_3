package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;

    private final By loginInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    private final By accountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private final By constructorButton = By.xpath(".//p[text() = 'Конструктор']");

    private final By ordersListButton = By.xpath(".//p[text() = 'Лента Заказов']");

    private final By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    private final By buildBurgerText = By.xpath(".//h1[text() = 'Соберите бургер']");

    private final By logo = By.className("AppHeader_header__logo__2D0X2");

    private final By bunsLink = By.xpath(".//span[text() = 'Булки']");
    private final By bunsText = By.xpath(".//h2[text() = 'Булки']");


    private final By sauceLink = By.xpath(".//span[text() = 'Соусы']");
    private final By sauceText = By.xpath(".//h2[text() = 'Соусы']");


    private final By fillingsLink = By.xpath(".//span[text() = 'Начинки']");
    private final By fillingsText = By.xpath(".//h2[text() = 'Начинки']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginInButton() {
        driver.findElement(loginInButton).click();
    }

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickOrdersListButton() {
        driver.findElement(ordersListButton).click();
    }

    public boolean orderButtonIsDisplayed() {
        return driver.findElement(orderButton).isDisplayed();
    }

    public boolean buildBurgerTextIsDisplayed() {
        return driver.findElement(buildBurgerText).isDisplayed();
    }

    public void clickToLogo() {
        driver.findElement(logo).click();
    }

    public void clickBunsLink() {
        driver.findElement(bunsLink).click();
    }

    public boolean bunsTextIsDisplayed() {
        return driver.findElement(bunsText).isDisplayed();
    }

    public void clickSauceLink() {
        driver.findElement(sauceLink).click();
    }

    public boolean sauceTextIsDisplayed() {
        return driver.findElement(sauceText).isDisplayed();
    }

    public void clickFillingsLink() {
        driver.findElement(fillingsLink).click();
    }

    public boolean fillingsTextIsDisplayed() {
        return driver.findElement(fillingsText).isDisplayed();
    }
}
