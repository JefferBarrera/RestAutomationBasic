package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CrearUsuario implements Task {

    private final String name;
    private final String job;

    public CrearUsuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String requestBody =
                "{" +
                    "\"name\":" + name + "," +
                    "\"job\":" + job +
                "}";

        actor.attemptsTo(
                Post.to("/users").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(requestBody)
                )
        );
    }

    public static Performable then(String name, String job) {
        return Instrumented.instanceOf(CrearUsuario.class).withProperties(name, job);
    }
}
