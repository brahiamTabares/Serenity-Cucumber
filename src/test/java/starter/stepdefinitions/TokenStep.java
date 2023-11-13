package starter.stepdefinitions;

import dtos.AutenticationRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.hamcrest.Matchers;
import questions.ContentToken;
import questions.TokenGenerationValidation;
import tasks.TokenUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class TokenStep {
     private AutenticationRecord autenticacionRecord;
     private ContentToken contentToken;
    @Given("{actor} esta autenticado")
    public void el_administrador_esta_autenticado(Actor actor) {

        autenticacionRecord=new AutenticationRecord("admin","admin");
        //actor.attemptsTo(AutenticacionUser.create());
    }
    @When("{actor} invoca el servicio de generar tokens")
    public void el_administrador_invoca_el_servicio_de_generar_tokens(Actor actor) {

        actor.attemptsTo(TokenUser.withData(autenticacionRecord));

    }
    @Then("{actor} obtiene una respues que contiene el token")
    public void el_administrador_obtiene_una_respues_que_contiene_el_token(Actor actor) {
       // actor.should( seeThat(ContentToken.get(), Matchers.not( Matchers.emptyString() )) );

       actor.should(
                //seeThat(ContentToken.get(), Matchers.not( Matchers.emptyString() )));
                seeThat(TokenGenerationValidation.theTokenSchemaIs("tokenSchema")));

    }

    @Given("El administrador intenta autenticarse con datos incompletos")
    public void elAdministradorIntentaAutenticarseConDatosIncompletos() {
        autenticacionRecord=new AutenticationRecord("admin"," ");
    }
}
