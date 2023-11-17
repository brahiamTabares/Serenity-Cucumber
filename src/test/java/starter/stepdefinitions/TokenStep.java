package starter.stepdefinitions;

import dtos.AutenticationRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.hamcrest.Matchers;
import questions.ContentToken;
import net.serenitybdd.annotations.Shared;
import tasks.TokenUser;
import util.DataShared;
import util.GeneralData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class TokenStep {

    @Shared
    private GeneralData generalData;
    @Shared
    private DataShared dataShared;
    @Given("El {actor} esta autenticado")
    public void el_administrador_esta_autenticado(Actor actor) {

        actor.attemptsTo(TokenUser.withData(dataShared.autenticationRecord));

    }
    @When("El {actor} invoca el servicio de generar tokens")
    public void el_administrador_invoca_el_servicio_de_generar_tokens(Actor actor) {

        actor.attemptsTo(TokenUser.withData(dataShared.autenticationRecord));

    }
    @Then("El {actor} obtiene una respuesta que contiene el token")
    public void el_administrador_obtiene_una_respues_que_contiene_el_token(Actor actor) {
       actor.should(
                seeThat(ContentToken.get(), Matchers.not( Matchers.emptyString() )));
    }

    @Given("El {actor} intenta autenticarse con datos incompletos")
    public void elAdministradorIntentaAutenticarseConDatosIncompletos(Actor actor) {
        dataShared.autenticationRecord=new AutenticationRecord(dataShared.usuarioRecord.usuario()," ");
    }

    @Given("El {actor} intenta autenticarse con datos incorrectos")
    public void elAdministradorIntentaAutenticarseConDatosIncorrectos(Actor actor) {
        dataShared.autenticationRecord=new AutenticationRecord(dataShared.usuarioRecord.usuario(),generalData.getPassword());
    }
}
