package com.example.sandbox.getPet;

import com.example.sandbox.Common;
import com.example.sandbox.util.Assertions;
import com.example.sandbox.util.constans.TestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetDetailTest extends Common {


    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status/ID - pet detail test")
    public void T003(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        //Find Pets by status - 200
        Response  response = getUrl(findByStatus, queryParams);
        Assertions.assertReturnCode(response, 200);


        String id = response.jsonPath().get("[0].id").toString();

        //Response  response2 = getUrl(petById+id);

        //Find Pets by ID - 200
        Response  response2 = getUrl(petById.replace("{petId}", String.valueOf(id)));
        Assertions.assertReturnCode(response2, 200);

        //Find Pets by ID - 404 - Pet not found
        Response  response3 = getUrl(petById.replace("{petId}", String.valueOf(TestData.NON_EXIST_PET_ID)));
        Assertions.assertReturnCode(response3, 404);

        //Find Pets by ID - 400 - Invalid ID supplied
        //TODO - PET[GET] Find Pets by ID - 400 Invalid ID supplied
        /*
        Response  response4 = getUrl(petById.replace("{petId}", String.valueOf(..........)));
        Assertions.assertReturnCode(response4, 400);
        */

    }
}
