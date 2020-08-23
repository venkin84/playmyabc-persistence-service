package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.Sequencer;
import com.playmyabc.persistenceservice.repository.DBSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SequencerService {
    private DBSequenceRepository dbSequenceRepository;

    @Autowired
    public SequencerService(DBSequenceRepository dbSequenceRepository) {
        this.dbSequenceRepository = dbSequenceRepository;
    }

    //Ideally the seqName parameter has to be the QuestionSuite ID for QuestionUnitID Sequencing
    public long getNextSeqNumber(String seqName) {
        Optional<Sequencer> counter = dbSequenceRepository.findById(seqName);
        if (counter.isEmpty()) {
            Sequencer sequence = new Sequencer();
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
