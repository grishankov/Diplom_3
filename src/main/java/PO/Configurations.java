package PO;

// константы
public interface Configurations {
    String PATH_PAGE_LOGIN = "/login";
    String BASE_URL = "https://stellarburgers.nomoreparties.site";
    String BASE_URL_WITH_PATH = BASE_URL + "%s";
    String EMAIL_POSTFIX = "@yandex.ru";
    String PATH_PASSWORD_RECOVERY = "/forgot-password";
    String PATH_ACCOUNT_PROFILE = "/account/profile";
    String PATH_PAGE_REGISTER = "/register";
    int MAX_EMAIL_LENGTH = 20;
    int MAX_PASSWORD_LENGTH = 25;


    int MAX_NAME_LENGTH = 30;
}
