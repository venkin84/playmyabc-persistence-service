package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
