package starter.stepdefinitions;

import dtos.ClaveUserRecord;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import tasks.PatchUser;
import util.DataShared;
import util.GeneralData;

public class patchClaveStep {
@Shared
private DataShared dataShared;
@Shared
private GeneralData generalData;

private ClaveUserRecord claveUsuario;


    @When("El {actor} solicita actualizacion de una clave de usuario")
    public void el_admin_solicita_actualizacion_de_una_clave_de_usuario(Actor actor) {

        String nuevaClave= generalData.getPassword();
        ClaveUserRecord claveUsuarioRecord = new ClaveUserRecord(dataShared.usuarioRecord.clave(),nuevaClave,nuevaClave);
        System.out.println(dataShared.usuarioRecord.usuario());
        actor.attemptsTo(PatchUser.withData(claveUsuarioRecord,dataShared.usuarioRecord.usuario()));

       // dataShared.usuarioRecord = new UsuarioRecord(dataShared.usuarioRecord.usuario(), claveUsuarioRecord.nuevaClave(), dataShared.usuarioRecord.roles());

    }


    @When("El {actor} solicita actualizacion de una clave de usuario con datos incompletos")
    public void elAdminSolicitaActualizacionDeUnaClaveDeUsuarioConDatosIncompletos(Actor actor) {

        String nuevaClave= "";
        ClaveUserRecord claveUsuarioRecord = new ClaveUserRecord(dataShared.usuarioRecord.clave(),nuevaClave,nuevaClave);
        System.out.println(dataShared.usuarioRecord.usuario());
        actor.attemptsTo(PatchUser.withData(claveUsuarioRecord,dataShared.usuarioRecord.usuario()));

    }
}
