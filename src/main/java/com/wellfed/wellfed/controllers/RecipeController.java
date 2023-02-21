package com.wellfed.wellfed.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellfed.wellfed.models.Recipe;
import com.wellfed.wellfed.repositories.RecipeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

  @Autowired
  RecipeRepository recipeRepository;

  // Gets
  @GetMapping("/{id}")
  public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") String id) {
    Optional<Recipe> _recipe;
    try {
      _recipe = recipeRepository.findById(id);
    } catch (Exception error) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (_recipe.isPresent()) {
      return new ResponseEntity<Recipe>(_recipe.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<Recipe>> getRecipesByAuthor(@RequestBody String authorId) {
    try {
      return new ResponseEntity<List<Recipe>>(recipeRepository.findByAuthorId(authorId), HttpStatus.OK);
    } catch (Exception error) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Posts
  @PostMapping("")
  public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
    try {
      Recipe _recipe = recipeRepository.save(new Recipe(recipe.getName(), recipe.getAuthorId(), recipe.getTime(),
          recipe.getComplexityId(), recipe.getDescription(), recipe.getTools(), recipe.getIngredients(),
          recipe.getSteps(),
          recipe.getTags(),
          recipe.getServes(), recipe.getPictureId()));
      return new ResponseEntity<>(_recipe, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // Puts
  @PutMapping("/{id}")
  public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe) {
    Optional<Recipe> recipeData = recipeRepository.findById(id);

    if (recipeData.isPresent()) {
      Recipe _recipe = recipeData.get();
      _recipe.setName(recipe.getName());
      _recipe.setAuthorId(recipe.getAuthorId());
      _recipe.setTime(recipe.getTime());
      _recipe.setComplexityId(recipe.getComplexityId());
      _recipe.setDescription(recipe.getDescription());
      _recipe.setTools(recipe.getTools());
      _recipe.setIngredients(recipe.getIngredients());
      _recipe.setSteps(recipe.getSteps());
      _recipe.setTags(recipe.getTags());
      _recipe.setServes(recipe.getServes());
      _recipe.setPictureId(recipe.getPictureId());
      return new ResponseEntity<>(recipeRepository.save(_recipe), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Deletes

}
