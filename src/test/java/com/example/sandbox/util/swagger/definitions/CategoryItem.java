package com.example.sandbox.util.swagger.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryItem {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    //getter

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    //setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
