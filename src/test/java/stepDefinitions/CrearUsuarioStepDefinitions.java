package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.PathResponseQuestion;
import tasks.CrearUsuario;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class CrearUsuarioStepDefinitions {

    @Given("queremos crear un usuario {string} {string}")
    public void queremosCrearUnUsuario(String name, String job) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearUsuario.then(name, job)
        );
    }

    @And("validamos creacion del usuario")
    public void validamosCreacionDelUsuario() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("validando creacion",
                        response -> response
                                .body("$", hasKey("createdAt"))
                )
        );


        OnStage.theActorInTheSpotlight().should(
                seeThat("validando creacion", new PathResponseQuestion("createdAt"), equalTo(true))
        );
    }
}
