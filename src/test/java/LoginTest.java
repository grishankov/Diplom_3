import PO.*;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest {
    private final UserOperations userOperations = new UserOperations();
    private Map<String, String> userData;

    @Before
    public void generateData() {
        userData = userOperations.register();
    }

    @Test
    @DisplayName("Login main page")
    @Description("Login page + .//button[text()='Войти']")
    public void loginMainPageTest() {
        MainPageObject mainPO = open(MainPageObject.getFullPath(), MainPageObject.class);
        mainPO.clickButtonLogInAccount();
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login personal account")
    @Description("Login page + .//button[text()='Войти']")
    public void loginButtonPersonalAccountTest() {
        MainPageObject mainPO = open(MainPageObject.getFullPath(), MainPageObject.class);
        mainPO.clickButtonPersonalArea();
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login button registration form")
    @Description("Registration page + .//button[text()='Войти']")
    public void loginRegistrationFormTest() {
        RegistrationPageObject registrationPO = open(MainPageObject.getFullPath(Configurations.PATH_PAGE_REGISTER), RegistrationPageObject.class);
        registrationPO.clickButtonSignIn();
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Login password recovery form")
    @Description("Password recovery page + .//button[text()='Войти']")
    public void loginPasswordRecoveryFormTest() {
        PasswordPageObject passwordPO = open(MainPageObject.getFullPath(Configurations.PATH_PASSWORD_RECOVERY), PasswordPageObject.class);
        passwordPO.clickButtonSignIn();
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickButtonConstructor();
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }
}