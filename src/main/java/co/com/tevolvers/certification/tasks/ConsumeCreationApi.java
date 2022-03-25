package co.com.tevolvers.certification.tasks;


import co.com.tevolvers.certification.models.Booking;
import co.com.tevolvers.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

public class ConsumeCreationApi implements Task {

    private Booking data;

    public ConsumeCreationApi(List<Booking> data) {
        this.data = data.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String body = String.format("{\n" +
                        "    \"firstname\" : \"%s\",\n" +
                        "    \"lastname\" : \"%s\",\n" +
                        "    \"totalprice\" : %s,\n" +
                        "    \"depositpaid\" : %b,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"%s\",\n" +
                        "        \"checkout\" : \"%s\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"%s\"\n" +
                        "}",data.getFirstname(),data.getLastname(),data.getTotalprice(),data.getDepositpaid()
        ,data.getCheckin(),data.getCheckout(),data.getAdditionalneeds());

        actor.attemptsTo(
                Post.to(Constants.ENDPOINT).with(request -> request.contentType(JSON).
                        header("Content-Type", "application/json")
                    .body(body).relaxedHTTPSValidation())
        );
        actor.remember("firstName",data.getFirstname());
        actor.remember("lastName",data.getLastname());
        actor.remember("id",SerenityRest.lastResponse().jsonPath().getString("bookingid"));
    }

    public static ConsumeCreationApi consumeApi(List<Booking> data){
        return Tasks.instrumented(ConsumeCreationApi.class,data);
    }
}
