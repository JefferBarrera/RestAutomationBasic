package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class EliminarUsuario implements Task {

    private final int id;

    public EliminarUsuario(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/users/" + id).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );
    }

    public static Performable then(int id) {
        return Instrumented.instanceOf(EliminarUsuario.class).withProperties(id);
    }
}
