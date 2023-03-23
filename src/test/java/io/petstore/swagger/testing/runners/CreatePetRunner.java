package io.petstore.swagger.testing.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CreatePet.feature",
        glue = "io/petstore/swagger/testing/stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class CreatePetRunner {
}
