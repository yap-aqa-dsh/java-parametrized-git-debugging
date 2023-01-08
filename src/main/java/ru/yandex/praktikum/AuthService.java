package ru.yandex.praktikum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthService {

    public static boolean isUserCredentialsValid(String login, String password) {
        return isLoginValid(login) && isPasswordValid(password);
    }

    private static boolean isLoginValid(String login) {
        boolean isValidEmail = isDataValidByRegex(login, "^(.+)@(.+)$");
        boolean isValidPhoneNumber = isDataValidByRegex(login, "^\\+(?:[0-9]?){6,14}[0-9]$");
        return isValidEmail || isValidPhoneNumber;
    }

    private static boolean isPasswordValid(String password) {
        return isDataValidByRegex(password, "^(.){5,10}$");
    }

    private static boolean isDataValidByRegex(String data, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

}
