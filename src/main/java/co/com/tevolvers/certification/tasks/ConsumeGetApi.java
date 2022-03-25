package co.com.tevolvers.certification.tasks;

import co.com.tevolvers.certification.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsumeGetApi implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String bookingId = "/"+actor.recall("id").toString();
        actor.attemptsTo(
                Get.resource(Constants.ENDPOINT+bookingId)
        );
        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static ConsumeGetApi consumeApi(){
        return Tasks.instrumented(ConsumeGetApi.class);
    }
}
