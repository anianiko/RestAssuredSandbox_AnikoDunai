package com.example.sandbox.getPetList;

import com.example.sandbox.Common;
import com.example.sandbox.util.Assertions;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetListTest extends Common {

    //      |--------------------PET[GET] Find Pets by status---------------------------|

    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status (AVAILABLE) - response code: 200")
    public void T005(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response  response = getUrl(findByStatus, queryParams);
        //Assert.assertEquals() with assertion error message:
        //Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
        Assertions.assertReturnCode(response, 200);
    }

    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status (PENDING) - response code: 200")
    public void T019(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","pending");

        Response  response = getUrl(findByStatus, queryParams);
        Assertions.assertReturnCode(response, 200);

    }

    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status (SOLD) - response code: 200")
    public void T020(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","sold");

        Response  response = getUrl(findByStatus, queryParams);
        Assertions.assertReturnCode(response, 200);

    }

    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status (invalid status value) - response code: 400")
    public void T021(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","NonExistStatus");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),400,"Invalid response code");
    }


    @Test(enabled = true,groups = {SMOKE},description ="PET[GET] Find Pets by status")
    public void T006(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");
        Map<String, String> headers = new TreeMap<>();
        headers.put("Mandatoyheader","BFG");

        Response  response = getUrl(findByStatus,headers,queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

    }
}
