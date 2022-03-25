package co.com.tevolvers.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class CreateValidation implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new EqualsBuilder()
                .append(SerenityRest.lastResponse().statusCode(),200)
                .append(actor.recall("firstName").toString(),SerenityRest.lastResponse().jsonPath().getString("booking.firstname"))
                .append(actor.recall("lastName").toString(),SerenityRest.lastResponse().jsonPath().getString("booking.lastname"))
                .isEquals();
    }

    public static CreateValidation creacion(){
        return new CreateValidation();
    }
}
