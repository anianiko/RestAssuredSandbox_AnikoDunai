package com.example.sandbox;

import io.restassured.response.Response;
import org.junit.Assert;

public class Assertions {
    public void assertReturnCode(Response response,Integer code){
        Assert.assertEquals((Integer) response.getStatusCode(),code);
    }
}
