package com.example.sandbox.postNewPet;

import com.example.sandbox.Common;
import com.example.sandbox.util.body.pet.JsonBody;
import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.body.pet.PostCreatePetSimple;
import com.example.sandbox.util.swagger.definitions.Item;
import com.example.sandbox.util.swagger.definitions.PetBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.PET_PHOTO_URL_HYDRAIMAGE;
import static com.example.sandbox.util.constans.TestData.PET_NAME_01;

public class PostNewPetTest extends Common {

    //server response codes: 200, 405

    @Test(enabled = true,groups = {SMOKE},description ="PET[POST] Add a new pet to the store - Pet object with all valid data - expected response code: 200")
    public void T001(){

        //200
        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(generateRandomNumber())
                        .category(Item.builder()
                                .id(1)
                                .name("Hydra")
                                .build())
                        .name("Princess")
                        .photoUrl(PET_PHOTO_URL_HYDRAIMAGE)
                        .tag(Item.builder()
                                .id(2)
                                .name("cute")
                                .build())
                        .status("available")
                        .build()
                ).build();


        Response response = postUrl(newPet,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id = response.jsonPath().get("id").toString();

        //Response  response2 = getUrl(petById+id);

        Response  response2 = getUrl(petById.replace("{petId}", String.valueOf(id)));
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }

    @Test(enabled = true,groups = {SMOKE},description ="PET[POST] Add a new pet to the store - Pet object with missing data")
    public void T002(){

        //405 invalid input
        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        //.id(generateRandomNumber())
                        //.category(Item.builder()
                        //        .id(0)//int64
                        //        .name("Hydra")
                        //        .build())
                        //.name("Princess")
                        //.photoUrl(HYDRAIMAGE)
                        //.tag(Item.builder()
                        //        .id(0)
                        //        .name("cute")
                        //        .build())
                        //.status("available")
                        .build()
                ).build();


        Response  response = postUrl(newPet,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),405,"Invalid response code");
    }


    @Test(enabled = true,groups = {SMOKE},description ="PET[POST] Add a new pet to the store - Create pet (SIMPLE) - expected response code: 200")
    public void T018() {

        JsonBody body = PostCreatePetSimple.postCreatePetSimple(PET_NAME_01);

        Response response = postUrl(newPet, createJsonBody((PostCreatePet) body));
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code");
    }
}
