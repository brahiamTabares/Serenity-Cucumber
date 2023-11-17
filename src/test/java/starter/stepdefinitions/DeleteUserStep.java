package starter.stepdefinitions;

import dtos.ClaveUserRecord;
import dtos.UsuarioRecord;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import tasks.DeleteUser;
import tasks.PatchUser;
import util.DataShared;
import util.GeneralData;

public class DeleteUserStep {
@Shared
private DataShared dataShared;
@Shared
private GeneralData generalData;


    @When("El {actor} elimina un usuario del sistema")
    public void el_admin_elimina_un_usuario_del_sistema(Actor actor) {

        actor.attemptsTo(DeleteUser.withData(dataShared.usuarioRecord.usuario()));
    }




}
