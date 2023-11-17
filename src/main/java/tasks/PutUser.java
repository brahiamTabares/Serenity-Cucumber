package tasks;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static util.Constants.getBaseUrlApi;


public class PutUser<T> implements Task {
    private final String usuarioActual;
    private final T usuario;
    public PutUser(String usuarioActual, T usuario) {

        this.usuarioActual = usuarioActual;
        this.usuario = usuario;
    }

    public static<T>  PutUser<T> withData(String usuarioActual, T usuario) {

        return new PutUser<T>(usuarioActual,usuario);
    }

    public < T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Put.to("/usuarios/" + usuarioActual)
                        .with(request -> request
                                .headers("Authorization", actor.gaveAsThe("token"))
                                .contentType(ContentType.JSON)
                                .body(usuario, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all())
        );
    }

}