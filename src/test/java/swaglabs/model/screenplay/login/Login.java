package swaglabs.model.screenplay.login;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static swaglabs.model.screenplay.login.LoginPage.*;

public class Login {
    public static Task WithCredentials(String username, String password){
        return Task.where("{0} attempts to login with username and password",
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue(username).into("#user-name"),
                Enter.theValue(password).into("#password"),
                Click.on(LOGIN_BUTTON)
        );
    }
}
