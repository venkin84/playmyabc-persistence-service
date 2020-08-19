package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.QuestionUnit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionUnitRepository extends MongoRepository<QuestionUnit, String> {
}
