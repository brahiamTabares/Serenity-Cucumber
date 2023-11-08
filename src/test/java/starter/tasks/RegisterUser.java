package starter.tasks;

import dtos.RegisterRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class RegisterUser implements Task {
    private final RegisterRecord registerRecord;

    public RegisterUser(RegisterRecord registerRecord) {
        this.registerRecord = registerRecord;
    }

    public static RegisterUser withData(RegisterRecord registerRecord) {
        return new RegisterUser(registerRecord);
    }


    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at("http://localhost:8090/api"));

        actor.attemptsTo(
                Post.to("/usuarios")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(registerRecord, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all()) // Opcional: Registrar detalles de la solicitud
        );
    }
}
