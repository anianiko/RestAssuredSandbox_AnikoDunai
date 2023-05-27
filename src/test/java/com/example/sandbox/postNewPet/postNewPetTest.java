package com.example.sandbox.postNewPet;

import com.example.sandbox.Common;
import com.example.sandbox.util.body.pet.PostCreatePet;
import com.example.sandbox.util.swagger.definitions.Item;
import com.example.sandbox.util.swagger.definitions.PetBody;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;
import static com.example.sandbox.util.constans.Tags.SMOKE;
import static com.example.sandbox.util.constans.TestData.HYDRAIMAGE;

public class postNewPetTest extends Common {

    //server response codes: 200, 405

    @Test(enabled = true,groups = {SMOKE},description ="PET[POST] Add a new pet to the store - Pet object with all valid data - expected response code: 200")
    public void TC001(){

        PostCreatePet body = PostCreatePet.builder()
                .PetBody(PetBody.builder()
                        .id(generateRandomNumber())
                        .category(Item.builder()
                                .id(1)
                                .name("Hydra")
                                .build())
                        .name("Princess")
                        .photoUrl(HYDRAIMAGE)
                        .tag(Item.builder()
                                .id(2)
                                .name("cute")
                                .build())
                        .status("available")
                        .build()
                ).build();


        Response  response = postUrl(newPet,createJsonBody(body));
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }

    @Test(enabled = true,groups = {SMOKE},description ="Add a new pet to the store - Pet object with missing data - expected response code: 405")
    public void TC002(){

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

}
