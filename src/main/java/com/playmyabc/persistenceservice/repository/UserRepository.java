package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
