package com.wellfed.wellfed.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wellfed.wellfed.models.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    
    List<Recipe> findByAuthorId(String authorId);

    List<Recipe> findByName(String name);

    Optional<Recipe> findById(String id);

    //Don't have to implement save(), findOne(), findById(), findAll(), count(), delete(), deleteById() because MongoRepository already has them for us

}
