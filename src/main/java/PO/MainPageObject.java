package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageObject {

    public static String getFullPath(String path) {
        return String.format(Configurations.BASE_URL_WITH_PATH, path);
    }

    public static String getFullPath() {
        return Configurations.BASE_URL;
    }

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement buttonLogInAccount;

    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement logoConstructorBurger;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement buttonPersonalArea;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoStellarBurgers;

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement buttonConstructor;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement toggleSouse;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement toggleBun;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement toggleIngredients;

    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[1]")
    private SelenideElement catalogBun;

    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[2]")
    private SelenideElement catalogSouse;

    @FindBy(how = How.XPATH, using = "(.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[3]")
    private SelenideElement catalogIngredients;

    public SelenideElement getButtonLogInAccount() {
        return buttonLogInAccount;
    }

    public SelenideElement getLogoConstructorBurger() {
        return logoConstructorBurger;
    }

    public SelenideElement getButtonPersonalArea() {
        return buttonPersonalArea;
    }

    public SelenideElement getButtonConstructor() {
        return buttonConstructor;
    }

    public SelenideElement getLogoStellarBurgers() {
        return logoStellarBurgers;
    }

    public SelenideElement getToggleSouse() {
        return toggleSouse;
    }

    public SelenideElement getToggleBun() {
        return toggleBun;
    }

    public SelenideElement getToggleIngredients() {
        return toggleIngredients;
    }

    public SelenideElement getCatalogBun() {
        return catalogBun;
    }

    public SelenideElement getCatalogSouse() {
        return catalogSouse;
    }

    public SelenideElement getCatalogIngredients() {
        return catalogIngredients;
    }

    @Step("Account button enter click")
    public void clickButtonLogInAccount() {
        getButtonLogInAccount().click();
    }

    @Step("Personal area button click")
    public void clickButtonPersonalArea() {
        getButtonPersonalArea().click();
    }

    @Step("Constructor button click")
    public void clickButtonConstructor() {
        getButtonConstructor().click();
    }

    @Step("Logo click")
    public void clickLogoStellarBurgers() {
        getLogoStellarBurgers().click();
    }

    @Step("Souse switcher click")
    public void clickToggleSouse() {
        getToggleSouse().click();
    }

    @Step("Buns switcher click")
    public void clickToggleBun() {
        getToggleBun().click();
    }

    @Step("Ingredients switcher click")
    public void clickToggleIngredients() {
        getToggleIngredients().click();
    }
}
