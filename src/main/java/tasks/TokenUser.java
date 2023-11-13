package tasks;

import dtos.AutenticationRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static util.Constants.BASE_URL_API;

public class TokenUser implements Task {
    private final AutenticationRecord autenticationRecord;

    public TokenUser(AutenticationRecord autenticationRecord) {
        this.autenticationRecord = autenticationRecord;
    }

    public static TokenUser withData(AutenticationRecord autenticationRecordRecord) {

        return new TokenUser(autenticationRecordRecord);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

       actor.whoCan(CallAnApi.at(BASE_URL_API));

        actor.attemptsTo(
                Post.to("/tokens")
                        .with(requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
//                                .body(actor.gaveAsThe("credential"), ObjectMapperType.GSON)
                                        .body(autenticationRecord, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all()) // Opcional: Registrar detalles de la solicitud
        );
        actor.remember("token", SerenityRest.lastResponse().getHeader("Authorization"));

    }
}
