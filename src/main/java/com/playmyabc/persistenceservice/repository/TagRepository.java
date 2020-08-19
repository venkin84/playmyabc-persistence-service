package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
}
