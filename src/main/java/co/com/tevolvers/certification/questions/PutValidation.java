package co.com.tevolvers.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class PutValidation implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new EqualsBuilder()
                .append(SerenityRest.lastResponse().statusCode(),200)
                .append(actor.recall("firstNamePut").toString(),SerenityRest.lastResponse().jsonPath().getString("firstname"))
                .append(actor.recall("totalprice").toString(),SerenityRest.lastResponse().jsonPath().getString("totalprice"))
                .isEquals();
    }

    public static PutValidation update(){
        return new PutValidation();
    }
}
