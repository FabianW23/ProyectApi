package co.com.tevolvers.certification.tasks;


import co.com.tevolvers.certification.models.Booking;
import co.com.tevolvers.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

public class ConsumePutApi implements Task {

    private Booking data;

    public ConsumePutApi(List<Booking> data) {
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
        String bookingId = "/"+actor.recall("id").toString();
        actor.attemptsTo(
                Put.to(Constants.ENDPOINT+bookingId).with(request -> request.contentType(JSON)
                        .header("Content-Type", "application/json")
                        .header("cookie", "token="+actor.recall("token").toString())
                        .body(body).relaxedHTTPSValidation())
        );
        System.out.println(SerenityRest.lastResponse().asString());
        actor.remember("firstNamePut",data.getFirstname());
        actor.remember("totalprice",data.getTotalprice());
    }

    public static ConsumePutApi consumeApi(List<Booking> data){
        return Tasks.instrumented(ConsumePutApi.class,data);
    }
}
