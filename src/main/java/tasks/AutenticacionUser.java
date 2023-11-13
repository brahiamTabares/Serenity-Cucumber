package tasks;

import dtos.AutenticationRecord;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class AutenticacionUser implements Task {

    public static AutenticacionUser create() {
        return new AutenticacionUser();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        var autenticationRecord = new AutenticationRecord("admin", "admin");
        actor.remember("credential", autenticationRecord);

    }
}
