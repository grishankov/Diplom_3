package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObject {
    @FindBy(how = How.XPATH, using = "(.//input[@class='text input__textfield text_type_main-default'])[1]")
    private SelenideElement fieldForEmail;

    @FindBy(how = How.XPATH, using = "(.//input[@class='text input__textfield text_type_main-default'])[2]")
    private SelenideElement fieldForPassword;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement buttonSignIn;

    public SelenideElement getFieldForEmail() {
        return fieldForEmail;
    }

    public SelenideElement getFieldForPassword() {
        return fieldForPassword;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    @Step("Enter in account")
    public void signInAccount(String userEmail, String userPassword) {
        getFieldForEmail().setValue(userEmail);
        getFieldForPassword().setValue(userPassword);
        getButtonSignIn().click();
    }
}