package Models;
//создание моделей

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.apache.commons.lang3.RandomStringUtils;

import static PO.Configurations.*;


public class User {
    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    private static String getRandomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static @NotNull String getRandomEmail() {
        return getRandomString(MAX_EMAIL_LENGTH / 2) + "@" + getRandomString(MAX_EMAIL_LENGTH / 4) + ".ru";
    }

    public static @NotNull String getRandomPassword() {
        return getRandomString(MAX_PASSWORD_LENGTH);
    }

    public static @NotNull String getRandomName() {
        return getRandomString(MAX_NAME_LENGTH);
    }

}