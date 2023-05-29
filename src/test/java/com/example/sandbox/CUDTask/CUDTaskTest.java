package com.example.sandbox.CUDTask;

import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.swagger.definitions.Item;
import com.example.sandbox.util.swagger.definitions.PetBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.*;

import com.example.sandbox.Common;

public class CUDTaskTest extends Common {

    //PET Create, Update, Delete pet process testing

    @Test(enabled = true,groups = {SMOKE}, priority=1,description ="PET[POST] Create a new /{petID} list element")
    public void T022_CUDTaskTest_1CreatePet() {

        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(PET_ID_01)
                        .category(Item.builder()
                                .id(PET_CATEGORY_ID)
                                .name(PET_CATEGORY_NAME)
                                .build())
                        .name(PET_NAME_01)
                        .photoUrl(PET_PHOTO_URL_TURTLE)
                        .tag(Item.builder()
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

        //getURL response - find pet by ID
        Response response2 = getUrl(petById.replace("{petId}", String.valueOf(id)));
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");

        //check pet name
        Response response3 = RestAssured
                .given()
                .when().get(baseUrl+petById.replace("{petId}", String.valueOf(id)))
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        String actualResultName = response3.jsonPath().getString("name");
        Assert.assertEquals(actualResultName, PET_NAME_01);

        //check petId
        int actualResultId = response3.jsonPath().getInt("id");
        Assert.assertEquals(actualResultId, PET_ID_01);

    }




       /*

        //PET[UPDATE] Update the /{petID} list element
        PutUpdatePet body2 = PutUpdatePet.builder()
                .PetBody(PetBody.builder()
                        .id(PET_ID_01)
                        .category(Item.builder()
                                .id(PET_CATEGORY_ID)
                                .name(PET_CATEGORY_NAME)
                                .build())
                        .name(PET_NAME_02)         //update pet's name
                        .photoUrl(PET_PHOTO_URL_HYDRAIMAGE)
                        .tag(Item.builder()
                                .id(PET_TAGS_ID)
                                .name(PET_TAGS_NAME)
                                .build())
                        .status(PET_STATUS)
                        .build()
                ).build();

        //postURL response
        Response response3 = postUrl(newPet,createJsonBody(body2));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id2 = response.jsonPath().get("id").toString();

        //getURL response
        Response  response4 = getUrl(petById.replace("{petId}", String.valueOf(id2)));
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");



        //PET[DELETE] Delete the /{petID} list element
        //TODO PET[DELETE] Delete the /{petID} list element

        */
}
