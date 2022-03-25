package co.com.tevolvers.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class PutWithBadTokenValidation implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return new EqualsBuilder()
                .append(SerenityRest.lastResponse().statusCode(),403)
                .isEquals();
    }

    public static PutWithBadTokenValidation update(){
        return new PutWithBadTokenValidation();
    }
}
