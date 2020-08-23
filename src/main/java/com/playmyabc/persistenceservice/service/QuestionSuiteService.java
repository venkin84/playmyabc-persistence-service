package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.QuestionSuite;
import com.playmyabc.persistenceservice.domain.subdomain.AppContext;
import com.playmyabc.persistenceservice.repository.QuestionSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class QuestionSuiteService {
    private QuestionSuiteRepository questionSuiteRepository;

    @Autowired
    public QuestionSuiteService (QuestionSuiteRepository questionSuiteRepository){
        this.questionSuiteRepository = questionSuiteRepository;
    }

    public QuestionSuite createQuestionSuite(QuestionSuite questionSuite){
        return questionSuiteRepository.insert(questionSuite);
    }

    public QuestionSuite readQuestionSuiteByID(String Id){
        Optional<QuestionSuite> questionSuite = questionSuiteRepository.findById(Id);
        if(questionSuite.isPresent()){
            return questionSuite.get();
        } else {
            return null;
        }
    }

    public QuestionSuite updateQuestionSuite(QuestionSuite questionSuite){
        // Need to find which are the params mentioned in the object to update them
        return null;
    }

    // Add or Remove a question to a question suite
    // Add or Remove Target Groups
    // Add or Update Comments
    // Add Likes
    // Add Views

    //Need to test this one
    @Transactional
    public Boolean deleteQuestionSuiteByID(String Id){
        // Need to delete all the Q unit associated to delete this Q Suite.
        questionSuiteRepository.deleteById(Id);
        return true;
    }
}
