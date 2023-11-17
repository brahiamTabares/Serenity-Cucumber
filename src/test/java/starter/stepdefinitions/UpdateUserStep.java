package starter.stepdefinitions;
import dtos.DataIncompleteRecord;
import dtos.UsuarioRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import tasks.PutUser;
import tasks.RegisterUser;
import util.DataShared;
import util.GeneralData;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.GetValueFromResponseBodyQuestion.theAttributeValue;

public class UpdateUserStep {
    private UsuarioRecord usuario1;
    private UsuarioRecord usuario2;

    private DataIncompleteRecord usuario3;
    @Shared
    private DataShared dataShared;
    @Shared
    private GeneralData generalData;

    @Given("El {actor} esta registrado en el sistema")
    public void hay_un_usuario_registrado(Actor actor) {
        if("admin".equals(actor.getName())){
            dataShared.usuarioRecord = generalData.getAdmin();
        }
        else {
            dataShared.usuarioRecord=generalData.getUser();
            actor.attemptsTo(RegisterUser.withData(dataShared.usuarioRecord));
        }
        dataShared.autenticationRecord = generalData.getCredential(dataShared.usuarioRecord);

    }
    @When("El {actor} solicita actualizacion de un usuario")
    public void el_administrador_solicita_actualizacion_de_un_usuario(Actor actor) {

        dataShared.usuarioRecord= new UsuarioRecord(dataShared.usuarioRecord.usuario(),generalData.getPassword(),dataShared.usuarioRecord.roles());

        actor.attemptsTo(PutUser.withData(dataShared.usuarioRecord.usuario(),dataShared.usuarioRecord));
    }


    @When("El {actor} solicita actualizacion de un usuario con datos incompletos")
    public void elAdministradorSolicitaActualizacionDeUnUsuarioConDatosIncompletos(Actor actor) {

        var usuario = new DataIncompleteRecord(dataShared.usuarioRecord.usuario());
        actor.attemptsTo(PutUser.withData(dataShared.usuarioRecord.usuario(),usuario));

    }

}
