package starter.stepdefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import tasks.ListToken;
import util.DataShared;
import util.GeneralData;

public class ListTokenSep {

    @Shared
    private DataShared dataShared;
    @Shared
    private GeneralData generalData;



    @When("El {actor} solicita el listado del tokens")
    public void el_admin_solicita_el_listado_del_tokens(Actor actor) {

        actor.attemptsTo(ListToken.withData());
    }
}
