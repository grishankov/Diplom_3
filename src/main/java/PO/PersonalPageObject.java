package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalPageObject {
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement labelProfile;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement buttonLogout;

    public SelenideElement getLabelProfile() {
        return labelProfile;
    }

    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }

    @Step("Enter button click")
    public void clickButtonLogout() {
        getButtonLogout().click();
    }
}
