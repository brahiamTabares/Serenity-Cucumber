package starter.stepdefinitions;
import dtos.RegisterRecord;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import com.github.javafaker.Faker;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.Set;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class registerStep extends UIInteractions {
   private RegisterRecord registerRecord;
    Faker faker = new Faker();
 String user = faker.name().username();

 String password = faker.internet().password();

    @Given("voy a registarme como un usuario no existente")
    public void voyARegistarmeComoUnUsuarioNoExistente() {

     registerRecord= new RegisterRecord(user, password,  Collections.singleton("use"));
    }


    @When("invoco el servicio de registro")
    public void invocoElServicioDeRegistro() {

     given().baseUri("http://localhost:8090/api")
             .basePath("/usuarios")
             .body(registerRecord, ObjectMapperType.GSON)
             .contentType(ContentType.JSON)
             .when()
             .accept(ContentType.JSON)
             .post();
    }


    @Then("obtengo un status code {int}")
    public void obtengoUnStatusCode(int expectedStatusCode) {
         then().statusCode(expectedStatusCode);

    }


    @Given("voy a registarme como un usuario con datos faltantes")
    public void voy_a_registarme_como_un_usuario_con_datos_faltantes() {
        registerRecord= new RegisterRecord(user, "", Collections.singleton("use"));
    }
    @Given("voy a registarme como un usuario ya existente")
    public void voy_a_registarme_como_un_usuario_ya_existente() {
        registerRecord= new RegisterRecord("pedro", "12345", Collections.singleton("use"));
    }




}

