package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PathResponseQuestion implements Question<Boolean> {

    public String key;

    public PathResponseQuestion(String key) {
        this.key = key;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SerenityRest.lastResponse().path(key) != null;
    }
}
