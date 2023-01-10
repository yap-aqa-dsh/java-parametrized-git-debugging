package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AuthServiceTest {

    private String login;
    private String password;
    private boolean expectedResult;

    public AuthServiceTest(String login, String password, boolean isValid) {
        this.login = login;
        this.password = password;
        this.expectedResult = isValid;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][] {
                // Login            Password        Expected Result
                {"test@gmail.com",  "12345",        true},
                {"test#gmail.com",  "qwerty",       false},
                {"+77777777777",    "hello",        true},
                {"87777777777",     "09876",        false},
                {"test@gmail.com",  "1234",         false},
                {"test#gmail.com",  "qwert",        false},
                {"+77777777777",    "hell",         false},
                {"87777777777",     "0987",         false},
        };
    }

    @Test
    public void userCredentialsValidationIsCorrect() {
        boolean actualResult = AuthService.isUserCredentialsValid(login, password);
        assertEquals(expectedResult, actualResult);
    }

}
