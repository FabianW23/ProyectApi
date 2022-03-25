package co.com.tevolvers.certification.stepdefinitions;

import co.com.tevolvers.certification.questions.AuthNegativeValidation;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookingNegativesStepdefinitions {

    @Then("^The api returns a reason bad credentials$")
    public void theApiReturnsAReasonBadCredentials() {
        theActorInTheSpotlight().should(seeThat(AuthNegativeValidation.validate()));
    }

    @When("^the user put a bad token$")
    public void theUserPutABadToken() {
        theActorInTheSpotlight().remember("token", "11111111111111111111");
    }

    @Then("^the api retuns status (\\d+)$")
    public void theApiRetunsStatus(int arg1) {
    }
}
