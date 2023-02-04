package com.wellfed.wellfed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.wellfed.wellfed.repositories.RecipeRepository;

@SpringBootApplication
@EnableMongoRepositories
public class WellfedApplication {
    @Autowired
    RecipeRepository recipeRepo;
	public static void main(String[] args) {
		SpringApplication.run(WellfedApplication.class, args);
	}

}
