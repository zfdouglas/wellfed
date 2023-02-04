package com.wellfed.wellfed.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellfed.wellfed.models.Author;
import com.wellfed.wellfed.repositories.AuthorRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    // Gets
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable("id") String id) {
        Optional<Author> _author;
        try {
            _author = authorRepository.findById(id);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (_author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Optional<Author>>(_author, HttpStatus.FOUND);
        }
    }

    // Posts
    @PostMapping("")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        try {
            Author _author = authorRepository.save(new Author(author.getUsername(), author.getFirstName(),
                    author.getLastName(), author.getEmail(), author.getAccountTypeId()));
            return new ResponseEntity<>(_author, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Deletes
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable("id") String id) {
        try {
            authorRepository.deleteById(id);
        } catch (IllegalArgumentException notFound) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
