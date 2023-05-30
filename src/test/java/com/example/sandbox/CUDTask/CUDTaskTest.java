package com.example.sandbox.CUDTask;

import com.example.sandbox.util.Assertions;
import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.swagger.definitions.CategoryItem;
import com.example.sandbox.util.swagger.definitions.PetBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.*;
import static io.restassured.RestAssured.given;

import com.example.sandbox.Common;

public class CUDTaskTest extends Common {

    //test data
    Integer id = PET_ID_01;
    String petByIdEndpoint = petById.replace("{petId}", String.valueOf(id));
    String endpointURL =baseUrl+petByIdEndpoint;

    //PET Create, Update, Delete pet process testing
    @Test(enabled = true,groups = {SMOKE}, priority=1,description ="PET[POST] Create a new /{petID} list element")
    public void T022_CUDTaskTest_1CreatePet() {

        //endpoint responses: 200, 405

        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(PET_ID_01)
                        .category(CategoryItem.builder()
                                .id(PET_CATEGORY_ID)
                                .name(PET_CATEGORY_NAME)
                                .build())
                        .name(PET_NAME_01)
                        .photoUrl(PET_PHOTO_URL_TURTLE)
                        .tag(CategoryItem.builder()
                                .id(PET_TAGS_ID)
                                .name(PET_TAGS_NAME)
                                .build())
                        .status(PET_STATUS)
                        .build()
                ).build();

        //postURL response
        Response response = postUrl(newPet,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id = response.jsonPath().get("id").toString();

        String endpointURL = baseUrl + petById.replace("{petId}", String.valueOf(id));

        //getURL response - find pet by ID
        Response response2 = getUrl(petById.replace("{petId}", String.valueOf(id)));
        Assertions.assertReturnCode(response2, 200);


        //check pet's name
        Response response3 = given()
                .when().get(endpointURL)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        String actualResultName = response3.jsonPath().getString("name");
        Assert.assertEquals(actualResultName, PET_NAME_01);

        //check petId
        int actualResultId = response3.jsonPath().getInt("id");
        Assert.assertEquals(actualResultId, PET_ID_01);

    }

    @Test(enabled = true,groups = {SMOKE}, priority=2,description ="PET[PUT] Update the name of /{petID} list element")
    public void T022_CUDTaskTest_2UpdatePet() {

        //endpoint responses: 400, 404, 405

        JSONObject updatePetRequest = new JSONObject();
        updatePetRequest.put("name",PET_NAME_02);

        Response response = putUrl(petByIdEndpoint, updatePetRequest.toJSONString());
        Assertions.assertReturnCode(response, 200);

        Response response5 = RestAssured
                .given()
                .when().get(endpointURL)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        //check the pet's updated name
        String newPetName = response5.jsonPath().getString("name");
        Assert.assertEquals(newPetName, PET_NAME_02);

    }


    @Test(enabled = true,groups = {SMOKE}, priority=3,description ="PET[DELETE] Delete /{petID} element")
    public void T022_CUDTaskTest_3DeletePet() {

        //endpoint responses: 400, 404

        Response response = deleteUrl(petByIdEndpoint);
        Assertions.assertReturnCode(response, 200);
    }

}
