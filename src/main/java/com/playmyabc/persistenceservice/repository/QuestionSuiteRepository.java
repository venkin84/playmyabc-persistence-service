package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.QuestionSuite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionSuiteRepository extends MongoRepository<QuestionSuite, String> {
}
