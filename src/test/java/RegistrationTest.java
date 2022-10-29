import Models.User;
import PO.Configurations;
import PO.LoginPageObject;
import PO.MainPageObject;
import PO.RegistrationPageObject;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest {

    @Test
    @DisplayName("Registration success")
    @Description("Main URL + .//button[text()='Войти в аккаунт']")
    public void registrationTest() {
        RegistrationPageObject registrationPO = open(MainPageObject.getFullPath(Configurations.PATH_PAGE_REGISTER), RegistrationPageObject.class);
        registrationPO.registerUser(User.getRandomName(), User.getRandomEmail(), User.getRandomPassword());
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Incorrect password check")
    @Description("Main URL + .//button[text()='Войти в аккаунт']")
    public void checkIncorrectPasswordTest() {
        RegistrationPageObject registrationPO = open(MainPageObject.getFullPath(Configurations.PATH_PAGE_REGISTER), RegistrationPageObject.class);
        registrationPO.setValueInFieldPassword("12345");
        registrationPO.getBadPasswordNotification().shouldBe(Condition.visible);
    }
}

