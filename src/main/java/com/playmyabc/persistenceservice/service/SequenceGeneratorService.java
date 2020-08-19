package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.DBSequence;
import com.playmyabc.persistenceservice.repository.DBSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SequenceGeneratorService {
    private DBSequenceRepository dbSequenceRepository;

    @Autowired
    public SequenceGeneratorService (DBSequenceRepository dbSequenceRepository) {
        this.dbSequenceRepository = dbSequenceRepository;
    }

    public long getNextSeqNumber(String seqName) {
        Optional<DBSequence> counter = dbSequenceRepository.findById(seqName);
        if (counter.isEmpty()) {
            DBSequence sequence = new DBSequence();
            sequence.setId(seqName);
            sequence.setSeq(1);
            dbSequenceRepository.insert(sequence);
            counter = Optional.of(sequence);
        } else {
            counter.get().setSeq(counter.get().getSeq() + 1);
            dbSequenceRepository.save(counter.get());
        }
        return counter.get().getSeq();
    }
}
