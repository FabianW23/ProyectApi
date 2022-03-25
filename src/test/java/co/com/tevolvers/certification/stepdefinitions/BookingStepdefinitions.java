package co.com.tevolvers.certification.stepdefinitions;


import co.com.tevolvers.certification.models.Booking;
import co.com.tevolvers.certification.models.Credentials;
import co.com.tevolvers.certification.questions.CreateValidation;
import co.com.tevolvers.certification.questions.GetValidation;
import co.com.tevolvers.certification.questions.PutValidation;
import co.com.tevolvers.certification.tasks.ConsumeAuthApi;
import co.com.tevolvers.certification.tasks.ConsumeCreationApi;
import co.com.tevolvers.certification.tasks.ConsumeGetApi;
import co.com.tevolvers.certification.tasks.ConsumePutApi;
import co.com.tevolvers.certification.utils.BaseUrlApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookingStepdefinitions {
    private EnvironmentVariables environmentVariable;

    @Given("^the user put the baseurl$")
    public void theUserPutTheBaseurl() {
        BaseUrlApi.defautBooking(environmentVariable);
    }

    @When("^the user consume the api post$")
    public void theUserConsumeTheApiPost(List<Booking> data) {
        theActorInTheSpotlight().attemptsTo(ConsumeCreationApi.consumeApi(data));
    }

    @Then("^the api retuns the booking id and the booking data$")
    public void theApiRetunsTheBookingIdAndTheBookingData() {
        theActorInTheSpotlight().should(seeThat(CreateValidation.creacion(), Matchers.is(true)));
    }

    @When("^the user consume the api get$")
    public void theUserConsumeTheApiGet() {
        theActorInTheSpotlight().attemptsTo(ConsumeGetApi.consumeApi());
    }

    @Then("^the api retuns the booking searched$")
    public void theApiRetunsTheBookingSearched() {
        theActorInTheSpotlight().should(seeThat(GetValidation.creacion(), Matchers.is(true)));
    }

    @When("^the user consume the auth$")
    public void theUserConsumeTheAuth(List<Credentials> data) {
        theActorInTheSpotlight().attemptsTo(ConsumeAuthApi.consumeApi(data));
    }

    @When("^the user consume the api put$")
    public void theUserConsumeTheApiPut(List<Booking> data) {
        theActorInTheSpotlight().attemptsTo(ConsumePutApi.consumeApi(data));
    }

    @Then("^the api retuns the updated booking data$")
    public void theApiRetunsTheUpdatedBookingData() {
        theActorInTheSpotlight().should(seeThat(PutValidation.update()));
    }

}
