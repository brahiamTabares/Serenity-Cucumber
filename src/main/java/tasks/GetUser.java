package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static util.Constants.BASE_URL_API;
import static util.Constants.getBaseUrlApi;

public class GetUser implements Task {
    private final String usuario;

    public GetUser(String usuario) {

        this.usuario = usuario;
    }

    public static GetUser withData(String usuario) {

        return new GetUser(usuario);
    }

    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Get.resource("/usuarios/" + usuario)
                        .with(request -> request.
                                headers("Authorization", actor.gaveAsThe("token"))
                                .log().all())
        );
    }
}