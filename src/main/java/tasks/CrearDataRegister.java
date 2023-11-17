package tasks;

import com.github.javafaker.Faker;
import dtos.UsuarioRecord;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Set;

public class CrearDataRegister implements Task {
    public static CrearDataRegister create() {
        return new CrearDataRegister();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        var registerRecord =new UsuarioRecord(faker.name().username(),faker.internet().password(), Set.of("user"));
        actor.remember("credential",registerRecord);
    }
}
