package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBody {

    @JsonProperty("id")
    private int id;

    @JsonProperty("petId")
    private int petId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("complete")
    private Boolean complete;
}
