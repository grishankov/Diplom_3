import PO.Configurations;
import PO.LoginPageObject;
import PO.MainPageObject;
import PO.PersonalPageObject;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountTest {

    private final UserOperations userOperations = new UserOperations();

    @Before
    public void generateData() {
        Map<String, String> userData = userOperations.register();
        LoginPageObject loginPO = open(MainPageObject.getFullPath(Configurations.PATH_PAGE_LOGIN), LoginPageObject.class);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
    }

    @Test
    @DisplayName("Move to personal account")
    @Description("Personal account page + .//a[text()='Профиль']")
    public void moveToPersonalAccountTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickButtonPersonalArea();
        PersonalPageObject personalPO = page(PersonalPageObject.class);
        personalPO.getLabelProfile().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Replace from personal area to constructor")
    @Description("Personal account page + .//p[text()='Конструктор']")
    public void replaceToConstructorTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickButtonPersonalArea();
        mainPO.clickButtonConstructor();
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Replace from personal use logo")
    @Description("Personal account page + AppHeader_header__logo__2D0X2")
    public void replaceToConstructorUseLogoTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickButtonPersonalArea();
        mainPO.clickLogoStellarBurgers();
        mainPO.getLogoConstructorBurger().shouldBe(Condition.visible);
    }


    @Test
    @DisplayName("Exit from account")
    @Description("Personal account page + .//button[text()='Выход']")
    public void logoutFromPersonalAccountTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickButtonPersonalArea();
        PersonalPageObject personalPO = page(PersonalPageObject.class);
        personalPO.clickButtonLogout();
        LoginPageObject loginPO = page(LoginPageObject.class);
        loginPO.getButtonSignIn().shouldBe(Condition.visible);
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }
}
