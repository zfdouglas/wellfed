package com.wellfed.wellfed.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipe")
public class Recipe {

    @Id
    String id;

    private String name;
    private String authorId;
    private Integer time;
    private String complexityId;
    private String description;
    private List<String> tools;
    private List<String> ingredients;
    private List<String> steps;
    private List<String> tags;
    private Integer serves;
    private String pictureId;

    public Recipe(String name, String authorId, Integer time, String complexityId, String description,
            List<String> tools,
            List<String> ingredients, List<String> steps, List<String> tags, Integer serves, String pictureId) {
        this.name = name;
        this.authorId = authorId;
        this.time = time;
        this.complexityId = complexityId;
        this.description = description;
        this.tools = tools;
        this.ingredients = ingredients;
        this.steps = steps;
        this.tags = tags;
        this.serves = serves;
        this.pictureId = pictureId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getComplexityId() {
        return this.complexityId;
    }

    public void setComplexityId(String complexityId) {
        this.complexityId = complexityId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public List<String> getTools() {
        return this.tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
    }

}
