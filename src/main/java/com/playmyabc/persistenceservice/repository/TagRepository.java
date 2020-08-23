package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends MongoRepository<Tag, String> {
    Optional<Tag> findByName(String tagName);
    List<Tag> findAllByNameIsLike(String nameLike);
}
