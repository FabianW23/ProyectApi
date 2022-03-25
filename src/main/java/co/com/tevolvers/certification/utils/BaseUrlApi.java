package co.com.tevolvers.certification.utils;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BaseUrlApi {

    public static void defautBooking(EnvironmentVariables environmentVariables){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Fabian");

        String baseUrl=environmentVariables.optionalProperty("https://restful-booker.herokuapp.com").orElse
                ("https://restful-booker.herokuapp.com");
        theActorInTheSpotlight().whoCan(CallAnApi.at(baseUrl));
    }
}
