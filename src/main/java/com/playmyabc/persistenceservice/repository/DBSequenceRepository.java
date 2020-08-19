package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.DBSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBSequenceRepository extends MongoRepository<DBSequence, String> {
}
