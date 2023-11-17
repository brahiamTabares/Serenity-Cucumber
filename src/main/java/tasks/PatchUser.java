package tasks;

import dtos.ClaveUserRecord;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static util.Constants.getBaseUrlApi;


public class PatchUser<T> implements Task {
    private final ClaveUserRecord claveUserRecord;
    private final String usuario;
    public PatchUser(ClaveUserRecord claveUserRecord, String usuario) {
        this.claveUserRecord = claveUserRecord;
        this.usuario = usuario;
    }
    public static <T>PatchUser <T>  withData(ClaveUserRecord claveUserRecord,String usuario) {
        return new PatchUser<T>(claveUserRecord,usuario);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Patch.to("/usuarios/" + usuario)
                        .with(request -> request
                                .headers("Authorization", actor.gaveAsThe("token"))
                                .contentType(ContentType.JSON)
                                .body(claveUserRecord, ObjectMapperType.GSON)
                        )
                        .with(request -> request.log().all())
        );
    }

}