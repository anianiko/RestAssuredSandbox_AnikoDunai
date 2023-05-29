package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetBody {

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private Item category;

    @JsonProperty("name")
    private String name;

    @Singular()
    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @Singular()
    @JsonProperty("tags")
    private List<Item> tags;        //swagger/definitions/Item.class

    @JsonProperty("status")
    private String status;
}
