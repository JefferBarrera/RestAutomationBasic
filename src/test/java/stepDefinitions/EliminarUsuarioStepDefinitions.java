package stepDefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.EliminarUsuario;

public class EliminarUsuarioStepDefinitions {
    @Given("queremos eliminar un usuario con id {int}")
    public void queremosEliminarUnUsuarioConId(int id) {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                EliminarUsuario.then(id)
        );
    }
}
