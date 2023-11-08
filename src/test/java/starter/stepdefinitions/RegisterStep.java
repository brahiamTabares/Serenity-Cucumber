package starter.stepdefinitions;

import dtos.RegisterRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import starter.tasks.RegisterUser;

import java.util.Collections;
import static net.serenitybdd.rest.SerenityRest.then;

public class RegisterStep extends UIInteractions {
    private RegisterRecord registerRecord;
    Faker faker = new Faker();
    String user = faker.name().username();

    String password = faker.internet().password();


    @Given("{actor} registra un usuario no existente")
    public void tobyRegistraUnUsuarioNoExistente(Actor actor) {

        registerRecord = new RegisterRecord(user, password, Collections.singleton("user"));

    }


    @When("{actor} invoca el servicio de registro")
    public void invocoElServicioDeRegistro(Actor actor) {


        actor.attemptsTo(RegisterUser.withData(registerRecord));

    /* given().baseUri("http://localhost:8090/api")
             .basePath("/usuarios")
             .body(registerRecord, ObjectMapperType.GSON)
             .contentType(ContentType.JSON)
             .when()
             .accept(ContentType.JSON)
             .post();*/
    }


    @Then("{actor} obtengo un status code {int}")
    public void obtengoUnStatusCode(Actor actor,int expectedStatusCode) {
         actor.then().statusCode(expectedStatusCode);

    }


    @Given("voy a registarme como un usuario con datos faltantes")
    public void voy_a_registarme_como_un_usuario_con_datos_faltantes() {
        registerRecord = new RegisterRecord(user, "", Collections.singleton("use"));
    }

    @Given("voy a registarme como un usuario ya existente")
    public void voy_a_registarme_como_un_usuario_ya_existente() {
        registerRecord = new RegisterRecord("pedro", "12345", Collections.singleton("use"));
    }


}

