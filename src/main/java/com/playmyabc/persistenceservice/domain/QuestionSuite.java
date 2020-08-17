package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.QuestionSuiteType;
import com.playmyabc.persistenceservice.domain.submodels.Content;
import org.bson.types.Binary;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionSuite {
    String id;
    String name;
    Binary image;
    QuestionSuiteType questionSuiteType;
    List<Group> authorGroups;
    List<Group> targetGroups;
    User author;
    List<String> questions;
    List<Content> contents;
    List<Tag> tags;
    Boolean enableComments;
    Boolean enableViewingQuestions;
    Boolean enableViewingAnswers;
    LocalDateTime createdOn;
    LocalDateTime expiresOn;
    LocalDateTime lastModifiedOn;
}
