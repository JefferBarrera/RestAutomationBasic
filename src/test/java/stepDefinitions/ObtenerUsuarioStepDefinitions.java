package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.ObtenerUsuario;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerUsuarioStepDefinitions {

    @Given("queremos obtener un usuario con id {int}")
    public void queremosObtenerUnUsuarioConId(int id) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                ObtenerUsuario.then(id)
        );
    }

    @And("validamos nombre del usuario {string}")
    public void validamosNombreDelUsuario(String name) {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse(
                        response -> response
                                .body("data.first_name", equalTo(name))
                )
        );
    }
}
