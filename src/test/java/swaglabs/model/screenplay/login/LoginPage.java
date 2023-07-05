package swaglabs.model.screenplay.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginPage {

    public static final Question<String> ERROR_MESSAGE = Text.of(".error-message-container");
    public static final String LOGIN_BUTTON = "#login-button";
}
