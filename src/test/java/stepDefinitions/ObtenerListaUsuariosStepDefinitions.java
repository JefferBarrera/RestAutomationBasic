package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import questions.ResponseCodeQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerListaUsuariosStepDefinitions {

    @Before
    public void actorSetup() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String restApiUrl = environmentVariables.getProperty("restapi.baseUrl");
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Sam").whoCan(CallAnApi.at(restApiUrl));
        SerenityRest.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new ErrorLoggingFilter());
    }

    @Given("queremos obtener lista de usuarios")
    public void queremosObtenerListaDeUsuarios() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                tasks.ObtenerListaUsuarios.then()
        );
    }

    @Then("validamos status code {int}")
    public void validamosStatusCode(int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("status code", new ResponseCodeQuestion(), equalTo(statusCode))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("status code",
                        response -> response.statusCode(statusCode))
        );
    }
}
