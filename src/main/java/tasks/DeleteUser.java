package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;


import static util.Constants.getBaseUrlApi;

public class DeleteUser implements Task {

    private String usuario;

    public DeleteUser(String usuario) {
        this.usuario = usuario;
    }

    public static DeleteUser withData(String usuario) {

        return new DeleteUser(usuario);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(getBaseUrlApi()));

        actor.attemptsTo(
                Delete.from("/usuarios/" + usuario)
                        .with(request -> request
                                .headers("Authorization", actor.gaveAsThe("token"))
                        ).with(request -> request.log().all())
        );


    }
}
