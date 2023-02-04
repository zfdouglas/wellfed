package com.wellfed.wellfed.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wellfed.wellfed.models.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findById(String id);

    List<Author> findByAccountTypeId(String accountTypeId);
}
