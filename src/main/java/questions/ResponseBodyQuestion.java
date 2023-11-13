package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBodyQuestion<T> implements Question<T> {

    private final String jsonPath;

    public ResponseBodyQuestion(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public static <T> Question<T> theAttributeValue(String jsonPath) {
        return new ResponseBodyQuestion<T>(jsonPath);
    }

    @Override
    public T answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().jsonPath().get(jsonPath);
    }
}
