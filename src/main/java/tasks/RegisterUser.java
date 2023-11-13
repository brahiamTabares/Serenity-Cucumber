package tasks;

import dtos.RegisterRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static util.Constants.BASE_URL_API;


public class RegisterUser implements Task {
    private final RegisterRecord registerRecord;


    public RegisterUser(RegisterRecord registerRecord) {
        this.registerRecord = registerRecord;
    }

    public static RegisterUser withData(RegisterRecord registerRecord) {

        return new RegisterUser(registerRecord);
    }




    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(BASE_URL_API));

        actor.attemptsTo(
                Post.to("/usuarios")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
//                                .body(actor.gaveAsThe("credential"), ObjectMapperType.GSON)
                                .body(registerRecord, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all()) // Opcional: Registrar detalles de la solicitud
        );
    }

}
