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
    private Integer id;

    @JsonProperty("petId")
    private Integer petId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("shipDate")
    private String shipDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("complete")
    private Boolean complete;

    //getter
    public Integer getId() {
        return id;
    }

    public Integer getPetId() {
        return petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getComplete() {
        return complete;
    }

    //setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
