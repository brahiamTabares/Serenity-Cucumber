package tasks;

import dtos.AutenticationRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static util.Constants.getBaseUrlApi;

public class ListToken implements Task {




    public static ListToken withData() {

        return new ListToken();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Get.resource("/tokens")
                        .with(requestSpecification -> requestSpecification
                                        .headers("Authorization", actor.gaveAsThe("token"))
                        )
                        .with(request -> request.log().all()) // Opcional: Registrar detalles de la solicitud
        );
        actor.remember("requestTokens", SerenityRest.lastResponse().getBody().asString());

    }
}
