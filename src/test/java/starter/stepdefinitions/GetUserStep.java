package starter.stepdefinitions;

import dtos.AutenticationRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import tasks.GetUser;
import tasks.TokenUser;
import util.DataShared;
import util.GeneralData;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.GetValueFromResponseBodyQuestion.theAttributeValue;

public class GetUserStep {

    @Shared
    private DataShared dataShared;
    @Shared
    private GeneralData generalData;
    @Given("El {actor} se autentico en el sistema")
    public void elAdminEstaAutenticadoEnElSistema(Actor actor) {
        actor.attemptsTo(TokenUser.withData(dataShared.autenticationRecord));
    }

    @When("El {actor} solicita informacion de {string}")
    public void elAdminSolicitaInformacionDeUnUsuario(Actor actor, String usuario) {

        dataShared.usuarioRecord = generalData.getAdmin();
        if( "el".equals(usuario) ){
            usuario = dataShared.usuarioRecord.usuario();
        }
        actor.attemptsTo(GetUser.withData(usuario));
    }

    @And("El {actor} obtiene los datos del usuario")
    public void elAdminObtieneLosDatosDelUsuario(Actor actor) {
        actor.should(
                seeThat(theAttributeValue("usuario"),equalTo(dataShared.usuarioRecord.usuario())),
                seeThat(theAttributeValue("roles").asListOf(String.class),equalTo(dataShared.usuarioRecord.roles()))
        );
    }
    @Given("El {actor} no esta autenticado en el sistema")
    public void el_admin_no_esta_autorizado_en_el_sistema(Actor actor) {
        actor.remember("token","");
    }

    @Given("{actor} autenticado no tiene permisos")
    public void el_admin_autenticado_no_tiene_permisos(Actor actor) {
        actor.attemptsTo(TokenUser.withData(new AutenticationRecord("pedro","12345")));
    }

    @When("El {actor} solicita informacion de usuario no existente")
    public void el_admin_solicita_informacion_en_un_recursos_no_existente(Actor actor) {
        actor.attemptsTo(GetUser.withData(generalData.getUsername()));
    }



}