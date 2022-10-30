package PO;
//создание РО

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordPageObject {
    @FindBy(how = How.XPATH, using = "(.//input[@class='text input__textfield text_type_main-default'])[1]")
    private SelenideElement fieldForEmail;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement buttonSignIn;


    public SelenideElement getFieldForEmail() {
        return fieldForEmail;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    @Step("Enter button click")
    public void clickButtonSignIn() {
        getButtonSignIn().click();
    }
}