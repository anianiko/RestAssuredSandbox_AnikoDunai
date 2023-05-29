package com.example.sandbox.util.body.pet;

import com.example.sandbox.util.swagger.definitions.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.example.sandbox.util.Tools.generateRandomNumber;
import static com.example.sandbox.util.constans.TestData.DEFAULT_IMAGE;

@SuperBuilder
@Getter
@Setter
public class PostCreatePetSimple extends PostCreatePet{

    // [POST] Create a pet simply
    public static JsonBody postCreatePetSimple(String name){
        PostCreatePet body = PostCreatePet.builder()
                .PetBody(com.example.sandbox.util.swagger.definitions.PetBody.builder()
                        .id(generateRandomNumber())
                        .category(Item.builder()
                                .id(999)
                                .name("non-categorized")
                                .build())
                        .name(name)
                        .photoUrl(DEFAULT_IMAGE)
                        .tag(Item.builder()
                                .id(0)
                                .name("")
                                .build())
                        .status("available")
                        .build()
                ).build();
        return body;
    }

}
