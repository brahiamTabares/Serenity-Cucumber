package starter.stepdefinitions;

import dtos.UsuarioRecord;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.github.javafaker.Faker;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import questions.StatusCode;
import questions.TokenGenerationValidation;
import tasks.RegisterUser;
import util.DataShared;
import util.GeneralData;
;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.ResponseBodyQuestion.theAttributeValue;

public class RegisterStep extends UIInteractions {




    @Shared
    private DataShared dataShared;

    @Shared
    private GeneralData generalData;
    @Given("El {actor} no existe en el sistema")
    public void tobyRegistraUnUsuarioNoExistente(Actor actor) {

        dataShared.usuarioRecord =generalData.getUser();

    }


    @When("El {actor} invoca el servicio de registro")
    public void invocoElServicioDeRegistro(Actor actor) {


        actor.attemptsTo(RegisterUser.withData(dataShared.usuarioRecord));
    }


    @Then("El {actor} obtiene un status code {int}")
    public void obtengoUnStatusCode(Actor actor, Integer expectedStatusCode) {
        ;

        actor.should(
                seeThat("el codigo de respuesta", StatusCode.code(), equalTo(expectedStatusCode))
        );
    }
    @Then("El {actor} la respuesta contiene los datos del usuario")
    public void brahiam_la_respuesta_contiene_los_datos_del_usuario(Actor actor) {
        actor.should(
                seeThat(theAttributeValue("usuario"),equalTo(dataShared.usuarioRecord.usuario())),
                seeThat(theAttributeValue("roles").asListOf(String.class),equalTo(dataShared.usuarioRecord.roles()))
        );
    }
    @And("El {actor} observa que la estructura cumple con el formato de {string}")
    public void elUsuarioObservaQueLaEstructuraCumpleConElFormato(Actor actor, String schema) {
        actor.should( seeThat(TokenGenerationValidation.theTokenSchemaIs("format"+schema)));
    }


    @Given("voy a registarme como un usuario con datos faltantes")
    public void voy_a_registarme_como_un_usuario_con_datos_faltantes() {
        dataShared.usuarioRecord =generalData.getUserWithOutUsername();
    }


}

