package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.subdomain.*;
import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

// TODO update annotations for the sub fields
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document (collection = "question_suites")
public class QuestionSuite {
    @Id
    String id;

    @TextIndexed
    String name;

    @TextIndexed
    String description;
    Binary image;

    AppContext appContext;
    QuestionSuiteType questionSuiteType;

    @DBRef List<Group> authorGroups;
    @DBRef List<Group> targetGroups;
    @DBRef User author;
    @DBRef List<Tag> tags;
    List<Category> categoryList;

    List<QuestionUnit> questionUnits;
    List<Content> contents;
    Boolean enableComments;
    Boolean enableViewingQuestions;
    Boolean enableViewingAnswers;

    @CreatedDate
    LocalDateTime createdOn;
    @LastModifiedDate
    LocalDateTime lastModifiedOn;
    LocalDateTime deletedOn;
    LocalDateTime expiresOn;

    List<Comment> comments;
    long likes;
    long views;
}
