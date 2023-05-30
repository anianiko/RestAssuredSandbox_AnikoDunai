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
    private Integer id;

    @JsonProperty("category")
    private CategoryItem category;

    @JsonProperty("name")
    private String name;

    @Singular()
    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @Singular()
    @JsonProperty("tags")
    private List<CategoryItem> tags;        //swagger/definitions/Item.class

    @JsonProperty("status")
    private String status;

    //getter
    public Integer getId() {
        return id;
    }

    public CategoryItem getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<CategoryItem> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    //setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(CategoryItem category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(List<CategoryItem> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
