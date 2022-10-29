import Models.Token;
import Models.UserRegister;
import PO.Configurations;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserOperations {

    public Map<String, String> register() {
        String email = RandomStringUtils.randomAlphabetic(10) + Configurations.EMAIL_POSTFIX;
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        Map<String, String> inputDataMap = new HashMap<>();
        inputDataMap.put("email", email);
        inputDataMap.put("password", password);
        inputDataMap.put("name", name);
        UserRegister response = given()
                .spec(BaseSpec.getBaseSpec())
                .and()
                .body(inputDataMap)
                .when()
                .post("auth/register")
                .body()
                .as(UserRegister.class);
        Map<String, String> responseData = new HashMap<>();
        if (response != null) {
            responseData.put("email", response.getUser().getEmail());
            responseData.put("name", response.getUser().getName());
            responseData.put("password", password);
            Token.setAccessToken(response.getAccessToken().substring(7));
            Token.setRefreshToken(response.getRefreshToken());
        }
        return responseData;
    }

    public void delete() {
        if (Token.getAccessToken() == null) {
            return;
        }
        given()
                .spec(BaseSpec.getBaseSpec())
                .auth().oauth2(Token.getAccessToken())
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
    }
}