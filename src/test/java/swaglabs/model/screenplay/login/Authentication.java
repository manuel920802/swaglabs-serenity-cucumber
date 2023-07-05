package swaglabs.model.screenplay.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Test;
import org.junit.runner.RunWith;

import static swaglabs.model.screenplay.login.LoginPage.*;


@RunWith(SerenityRunner.class)
public class Authentication {
    @CastMember
    Actor james;

    @Test
    public void shouldRejectInvalidCredentials (){
        james.attemptsTo(
                Login.WithCredentials(
                "invalid-username", "invalid-password"),
                Ensure.that(ERROR_MESSAGE).contains("Epic sadface: Username and password do not match any user in this service")
                );
    }

    @Test
    public void usernameCannotBeEmpty(){
        james.attemptsTo(
                Login.WithCredentials("", "invalid-password"),
                Ensure.that(ERROR_MESSAGE).contains("Epic sadface: Username is required")
                );
    }

    @Test
    public void passwordCannotBeEmpty(){
        james.attemptsTo(
                Login.WithCredentials("invalid-username", ""),
                Ensure.that(ERROR_MESSAGE).contains("Epic sadface: Password is required")
                );
    }
}
