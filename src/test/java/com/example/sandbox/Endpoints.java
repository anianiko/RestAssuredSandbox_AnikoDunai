package com.example.sandbox;

public class Endpoints {

    public static final String baseUrl = "https://petstore.swagger.io/v2";

    //-------------------------pet-------------------------
    public static final String findByStatus = "/pet/findByStatus";
    public static final String uploadImage = "/pet/{petId}/uploadImage";
    public static final String newPet = "/pet";
    public static final String petById = "/pet/{petId}";

    //-------------------------store-------------------------
    public static final String order = "/store/order";
    public static final String inventory = "/store/inventory";
    public static final String purchase = "/store/order/{orderId}";

    //-------------------------user-------------------------

    public static final String createWithArray = "/user/createWithArray";
    public static final String createWithList = "/user/createWithList";
    public static final String user = "/user/{username}";
    public static final String login = "/user/login";
    public static final String logout = "/user/logout";


}
