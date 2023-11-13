package starter.stepdefinitions;

import dtos.RegisterRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import questions.StatusCode;
import tasks.RegisterUser;
;
import java.util.List;
import java.util.Set;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.ResponseBodyQuestion.theAttributeValue;

public class RegisterStep extends UIInteractions {
    private RegisterRecord registerRecord;

    Faker faker = new Faker();
    String user = faker.name().username();


    @Given("{actor} registra un usuario no existente")
    public void tobyRegistraUnUsuarioNoExistente(Actor actor) {

        registerRecord =new RegisterRecord(faker.name().username(),faker.internet().password(), List.of("user"));

        //actor.attemptsTo(CrearDataRegister.create());
    }


    @When("{actor} invoca el servicio de registro")
    public void invocoElServicioDeRegistro(Actor actor) {


        actor.attemptsTo(RegisterUser.withData(registerRecord));
    }


    @Then("{actor} obtengo un status code {int}")
    public void obtengoUnStatusCode(Actor actor, Integer expectedStatusCode) {
        ;

        actor.should(
                seeThat("el codigo de respuesta", StatusCode.code(), equalTo(expectedStatusCode))
        );
    }
    @Then("{actor} la respuesta contiene los datos del usuario")
    public void brahiam_la_respuesta_contiene_los_datos_del_usuario(Actor actor) {
        actor.should(
                seeThat(theAttributeValue("usuario"),equalTo(registerRecord.usuario())),
                seeThat(theAttributeValue("roles").asListOf(String.class),equalTo(registerRecord.roles()))
        );
    }


    @Given("voy a registarme como un usuario con datos faltantes")
    public void voy_a_registarme_como_un_usuario_con_datos_faltantes() {
        registerRecord = new RegisterRecord(user, "", List.of("use"));
    }

    @Given("voy a registarme como un usuario ya existente")
    public void voy_a_registarme_como_un_usuario_ya_existente() {
        registerRecord = new RegisterRecord("admin", "admin", List.of("use"));
    }


}

