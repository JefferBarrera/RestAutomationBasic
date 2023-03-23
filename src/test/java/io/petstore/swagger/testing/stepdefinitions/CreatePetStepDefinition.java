package io.petstore.swagger.testing.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.petstore.swagger.testing.tasks.CreatePetTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import static io.petstore.swagger.testing.utils.enums.URLEnum.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CreatePetStepDefinition {

//    private Actor sam;

    @Before
    public void prepareActorStage() {
        setTheStage(new OnlineCast());
        theActorCalled("user").whoCan(CallAnApi.at(URL_BASE.getValue()));
//        sam = Actor.named("Sam").whoCan(CallAnApi.at(URL_BASE.getValue()));
    }

    @Given("^I want create to pet to service$")
    public void iWantCreateToPetToService() {
        theActorInTheSpotlight().attemptsTo(CreatePetTask.createPet());
//        sam.attemptsTo(CreatePetTask.createPet());
    }

    @Then("^I validate the status code (\\d+)$")
    public void iValidateTheStatusCode(int status) {
        theActorInTheSpotlight().should(
                ResponseConsequence.seeThatResponse(
                        validatableResponse -> validatableResponse.statusCode(status).log().all()
                )
        );
//        sam.should(ResponseConsequence.seeThatResponse(validatableResponse -> validatableResponse.statusCode(status)));
    }
}
