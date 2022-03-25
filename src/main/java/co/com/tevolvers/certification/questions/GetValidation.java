package co.com.tevolvers.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class GetValidation implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new EqualsBuilder()
                .append(SerenityRest.lastResponse().statusCode(),200)
                .append(actor.recall("firstName").toString(),SerenityRest.lastResponse().jsonPath().getString("firstname"))
                .append(actor.recall("lastName").toString(),SerenityRest.lastResponse().jsonPath().getString("lastname"))
                .isEquals();
    }

    public static GetValidation creacion(){
        return new GetValidation();
    }
}
