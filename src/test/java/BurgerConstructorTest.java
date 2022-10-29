import PO.Configurations;
import PO.LoginPageObject;
import PO.MainPageObject;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BurgerConstructorTest {
    private final UserOperations userOperations = new UserOperations();

    @Before
    public void generateData() {
        Map<String, String> userData = userOperations.register();
        LoginPageObject loginPO = open(MainPageObject.getFullPath(Configurations.PATH_PAGE_LOGIN), LoginPageObject.class);
        loginPO.signInAccount(userData.get("email"), userData.get("password"));
    }

    @Test
    @DisplayName("Switch to buns section")
    @Description("Main page + (.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[2]")
    public void switchToBunsTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickToggleSouse();
        mainPO.clickToggleBun();
        mainPO.getCatalogBun().shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Switch to souse section")
    @Description("Main page + (.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[2]")
    public void checkMoveToSouseTest() {
        MainPageObject mainPO = page(MainPageObject.class);
        mainPO.clickToggleSouse();
        mainPO.getCatalogSouse().shouldBe(Condition.visible);
    }


    @Test
    @DisplayName("Switch to ingredients section")
    @Description("Main page + (.//ul[@class='BurgerIngredients_ingredients__list__2A-mT'])[3]")
    public void switchToIngredientsTest() {
        MainPageObject mainPageObj = page(MainPageObject.class);
        mainPageObj.clickToggleIngredients();
        mainPageObj.getCatalogIngredients().shouldBe(Condition.visible);
    }


    @After
    public void tearDown() {
        userOperations.delete();
    }
}

