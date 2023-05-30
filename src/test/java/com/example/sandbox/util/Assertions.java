package com.example.sandbox.util;

import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.lang.Nullable;

public class Assertions {
    public static void assertReturnCode(Response response,Integer code){
        Assert.assertEquals(code, (Integer) response.getStatusCode());
    }
}
