package co.com.tevolvers.certification.tasks;


import co.com.tevolvers.certification.models.Booking;
import co.com.tevolvers.certification.models.Credentials;
import co.com.tevolvers.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static io.restassured.http.ContentType.JSON;

public class ConsumeAuthApi implements Task {

    private Credentials data;

    public ConsumeAuthApi(List<Credentials> data) {
        this.data = data.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String body = String.format("{\n" +
                        "    \"username\" : \"%s\",\n" +
                        "    \"password\" : \"%s\"\n" +
                        "}",data.getUsername(),data.getPassword());

        actor.attemptsTo(
                Post.to(Constants.ENDPOINT_AUTH).with(request -> request.contentType(JSON).
                        header("Content-Type", "application/json")
                    .body(body).relaxedHTTPSValidation())
        );
        actor.remember("token",SerenityRest.lastResponse().jsonPath().getString("token"));
    }

    public static ConsumeAuthApi consumeApi(List<Credentials> data){
        return Tasks.instrumented(ConsumeAuthApi.class,data);
    }
}
