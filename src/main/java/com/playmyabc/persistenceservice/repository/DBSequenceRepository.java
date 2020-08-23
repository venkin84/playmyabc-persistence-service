package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.Sequencer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DBSequenceRepository extends MongoRepository<Sequencer, String> {
}
