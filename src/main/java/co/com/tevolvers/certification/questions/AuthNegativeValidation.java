package co.com.tevolvers.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class AuthNegativeValidation implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new EqualsBuilder()
                .append(SerenityRest.lastResponse().statusCode(),200)
                .append("Bad credentials",SerenityRest.lastResponse().jsonPath().getString("reason"))
                .isEquals();
    }

    public static AuthNegativeValidation validate(){
        return new AuthNegativeValidation();
    }
}
