package com.wellfed.wellfed.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.wellfed.wellfed.models.Tag;

public interface TagRepository extends MongoRepository<Tag, String> {
    Optional<List<Tag>> findAllByDisplayName(String displayName);

}
