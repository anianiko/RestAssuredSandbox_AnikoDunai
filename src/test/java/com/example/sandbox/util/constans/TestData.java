package com.example.sandbox.util.constans;

public class TestData {

    //PET TEST DATA
    public static final Integer PET_ID_01 = 100000;
    public static final Integer NON_EXIST_PET_ID = 83567245;
    public static final Integer PET_CATEGORY_ID =6;
    public static final String PET_CATEGORY_NAME="turtle";
    public static final String PET_NAME_01 = "Sudo";
    public static final String PET_NAME_02 = "Speedy";
    public static final String PET_PHOTO_URL_HYDRAIMAGE = "https://gods-and-demons.fandom.com/wiki/Lernaean_Hydra?file=Venture_the_fog_hydra_by_darkcloud013_dbpdkjn-fullview.jpg";
    public static final String PET_PHOTO_URL_TURTLE ="https://upload.wikimedia.org/wikipedia/commons/3/34/Florida_Box_Turtle_Digon3.jpg";
    public static final String PET_DEFAULT_IMAGE = "https://images.squarespace-cdn.com/content/v1/540a27e8e4b042802a33c882/1516384291548-W46CZ9A6R0M6OOC49QUA/catBoarding.png";
    public static final Integer PET_TAGS_ID = 13;
    public static final String PET_TAGS_NAME ="Reptilia";
    public static final String PET_STATUS =PetStatus.available.toString();

    //USER TEST DATA
    public static final String USERNAME = "anianiko";
    public static final String FIRST_NAME = "Aniko";
    public static final String LAST_NAME = "Tester";
    public static final String EMAIL = "ani@aniko.com";
    public static final String PASSWORD = "HydraF0rPres1dent";
    public static final String PHONE = "0036901234567";

    //ORDER TEST DATA
    public static final Integer ORDER_ID = 1;
    public static final Integer ORDER_PET_ID = 0;
    public static final Integer ORDER_ITEM_QUANTITY = 0;
    public static final String ORDER_SHIPDATE ="2023-05-30T23:20:02.385Z";
    public static final String ORDER_STATUS = OrderStatus.placed.toString();
    public static final Boolean ORDER_COMPLETE = true;

}
