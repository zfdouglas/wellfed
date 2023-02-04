package com.wellfed.wellfed.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipe")
public class Recipe {

    @Id
    String id;

    private String name;
    private Author author;
    private Integer time;
    private Complexity complexity;
    private String description;
    private List<String> ingredients;
    private List<String> steps;
    private List<Tag> tags;
    private Integer serves;
    private String pictureId;




    public Recipe(String name, Author author, Integer time, Complexity complexity, String description, List<String> ingredients, List<String> steps, List<Tag> tags, Integer serves, String pictureId) {
        this.name = name;
        this.author = author;
        this.time = time;
        this.complexity = complexity;
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

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Complexity getComplexity() {
        return this.complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
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
    
}
