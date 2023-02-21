package com.wellfed.wellfed.controllers;

import com.wellfed.wellfed.models.Tag;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.wellfed.wellfed.repositories.TagRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    // gets
    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") String id) {
        Optional<Tag> returnedTag;
        try {
            returnedTag = tagRepository.findById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (returnedTag.isPresent()) {
            return new ResponseEntity<Tag>(returnedTag.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Tag>> getByDisplayName(@PathVariable("name") String name) {
        Optional<List<Tag>> returnedTags;
        try {
            returnedTags = tagRepository.findAllByDisplayName(name);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (returnedTags.isPresent()) {
            return new ResponseEntity<>(returnedTags.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // posts
    @PostMapping("")
    public ResponseEntity<String> createTag(@RequestBody Tag tagData) {
        Tag newTag;
        try {
            newTag = tagRepository.save(new Tag(tagData.getDisplayName()));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newTag.getId(), HttpStatus.CREATED);

    }

    // puts
    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tagData) {
        Optional<Tag> tagToUpdate = tagRepository.findById(tagData.getId());
        if (tagToUpdate.isPresent()) {
            Tag tag = tagToUpdate.get();
            tag.setDisplayName(tagData.getDisplayName());
            return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // deletes
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") String id) {
        try {
            tagRepository.deleteById(id);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
