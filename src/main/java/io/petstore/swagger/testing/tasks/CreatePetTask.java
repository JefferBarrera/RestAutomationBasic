package io.petstore.swagger.testing.tasks;

import io.petstore.swagger.testing.utils.enums.PetEnum;
import io.petstore.swagger.testing.utils.enums.URLEnum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CreatePetTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String body= "{\n" +
                "  \"id\": "+PetEnum.ID_PET.getValue()+",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+PetEnum.ID_CATEGORY.getValue()+",\n" +
                "    \"name\": \""+PetEnum.NAME_CATEGORY.getValue()+"\"\n" +
                "  },\n" +
                "  \"name\": \""+PetEnum.NAME_PET.getValue()+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \""+PetEnum.PHOTO_URL.getValue()+"\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+PetEnum.ID_TAG.getValue()+",\n" +
                "      \"name\": \""+PetEnum.NAME_TAG.getValue()+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+PetEnum.STATUS.getValue()+"\"\n" +
                "}";
        actor.attemptsTo(
                Post.to(URLEnum.URI_POST_PET.getValue())
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type","application/json")
                                .body(body)
                                .log().all()));
    }

    public static Performable createPet(){
        return Instrumented.instanceOf(CreatePetTask.class).withProperties();
//        return instrumented(CreatePetTask.class);
    }
}
