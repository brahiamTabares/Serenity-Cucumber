package tasks;

import dtos.UsuarioRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static util.Constants.getBaseUrlApi;


public class RegisterUser implements Task {
    private final UsuarioRecord usuarioRecord;


    public RegisterUser(UsuarioRecord usuarioRecord) {
        this.usuarioRecord = usuarioRecord;
    }

    public static RegisterUser withData(UsuarioRecord usuarioRecord) {

        return new RegisterUser(usuarioRecord);
    }




    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Post.to("/usuarios")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
//                                .body(actor.gaveAsThe("credential"), ObjectMapperType.GSON)
                                .body(usuarioRecord, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all()) // Opcional: Registrar detalles de la solicitud
        );
    }

}
