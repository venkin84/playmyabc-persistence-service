package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.Tag;
import com.playmyabc.persistenceservice.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagService (TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    // Create a Tag
    public Tag createTag (Tag tag) {
        // TODO Validation and Error Handling
        Optional<Tag> existingTag = tagRepository.findByName(tag.getName());
        if (existingTag.isPresent()) {
            // TODO notify that there is a tag with the same name
            return null;
        } else {
            // Ideal Scenario
            return tagRepository.insert(tag);
        }
    }

    // Get tag by Id
    public Tag getTagByID (String Id) {
        // TODO Validation and Error Handling
        Optional<Tag> existingTag = tagRepository.findById(Id);
        if (existingTag.isPresent()) {
            // Ideal Scenario
            return existingTag.get();
        } else {
            // TODO notify that there is no tag with this ID
            return null;
        }
    }

    // Get tags by name like
    public List<Tag> getTagsByNameLike (String nameLike) {
        // TODO Validation and Error Handling
        return tagRepository.findAllByNameIsLike(nameLike);
    }

    // Delete tag by Id
    public boolean deleteTagByID (String Id) {
        // TODO Validation and Error Handling
        Optional<Tag> existingTag = tagRepository.findById(Id);
        if (existingTag.isPresent()) {
            // Ideal Scenario
            tagRepository.delete(existingTag.get());
            return true;
        } else {
            // TODO notify that there is no tag with this ID to delete
            return false;
        }
    }
}
