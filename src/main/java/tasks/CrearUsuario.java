package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CrearUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String requestBody =
                "{" +
                "    \"name\": \"morpheus\"," +
                "    \"job\": \"leader\"" +
                "}";

        actor.attemptsTo(
                Post.to("/users").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(requestBody)
                )
        );
    }

    public static Performable then() {
        return Instrumented.instanceOf(CrearUsuario.class).withProperties();
    }
}
