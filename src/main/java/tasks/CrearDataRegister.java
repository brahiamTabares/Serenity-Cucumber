package tasks;

import com.github.javafaker.Faker;
import dtos.RegisterRecord;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.Collections;
import java.util.Set;

public class CrearDataRegister implements Task {
    public static CrearDataRegister create() {
        return new CrearDataRegister();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        var registerRecord =new RegisterRecord(faker.name().username(),faker.internet().password(), Set.of("user"));
        actor.remember("credential",registerRecord);
    }
}
