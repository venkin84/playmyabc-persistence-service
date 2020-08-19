package com.playmyabc.persistenceservice;

import com.playmyabc.persistenceservice.domain.QuestionUnit;
import com.playmyabc.persistenceservice.repository.QuestionUnitRepository;
import com.playmyabc.persistenceservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private SequenceGeneratorService sequenceGeneratorService;
    private QuestionUnitRepository questionUnitRepository;

    @Autowired
    public ApplicationRunner(SequenceGeneratorService sequenceGeneratorService,
                             QuestionUnitRepository questionUnitRepository) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.questionUnitRepository = questionUnitRepository;
    }
//    private MongoTemplate mongoTemplate;
////    private SequenceGeneratorService sequenceGeneratorService = new SequenceGeneratorService();
//
//    public ApplicationRunner(MongoTemplate mongoTemplate){
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    @Autowired
//    private MongoOperations mongoOperations;
//
//    public long getNextSeqNumber(String seqName){
//        DBSequence counter = mongoOperations.findAndModify(
//                query(where("_id").is(seqName)),
//                new Update().inc("seq", 1),
//                options().returnNew(true).upsert(true),
//                DBSequence.class
//        );
//        return counter.getSeq();
//    }
//
//    public long getSeqNumber(String seqName){
//        DBSequence counter = mongoTemplate.findById(seqName,
//                DBSequence.class
//        );
//        if(counter == null) {
//            DBSequence sequence = new DBSequence();
//            sequence.setId(seqName);
//            sequence.setSeq(1);
//            mongoTemplate.insert(sequence);
//            counter = sequence;
//        } else {
//            counter.setSeq(counter.getSeq()+1);
//            mongoTemplate.save(counter);
//        }
//        return counter.getSeq();
//    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Started... ");

        QuestionUnit questionUnit1 = new QuestionUnit();
        //Ideally the seqName parameter has to be the QuestionSuite ID
        questionUnit1.setQuestionUnitId(sequenceGeneratorService.getNextSeqNumber(QuestionUnit.SEQ_NAME));
        questionUnitRepository.insert(questionUnit1);
        System.out.println("Inserting Question Unit 01...");

        QuestionUnit questionUnit2 = new QuestionUnit();
        questionUnit2.setQuestionUnitId(sequenceGeneratorService.getNextSeqNumber(QuestionUnit.SEQ_NAME));
        questionUnitRepository.insert(questionUnit2);
        System.out.println("Inserting Question Unit 02...");
    }
}
