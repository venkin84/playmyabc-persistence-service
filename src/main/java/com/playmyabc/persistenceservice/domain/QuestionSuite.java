package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.Comment;
import com.playmyabc.persistenceservice.domain.submodels.QuestionSuiteType;
import com.playmyabc.persistenceservice.domain.submodels.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Document
public class QuestionSuite {
    @Id
    String id;

    @TextIndexed
    String name;

    @TextIndexed
    String description;
    Binary image;

    QuestionSuiteType questionSuiteType;

    @DBRef List<Group> authorGroups;
    @DBRef List<Group> targetGroups;
    @DBRef User author;
    @DBRef List<Tag> tags;

    List<QuestionUnit> questionUnits;
    List<Content> contents;
    Boolean enableComments;
    Boolean enableViewingQuestions;
    Boolean enableViewingAnswers;

    @CreatedDate
    LocalDateTime createdOn;
    @LastModifiedDate
    LocalDateTime lastModifiedOn;
    LocalDateTime expiresOn;

    List<Comment> comments;
    long likes;
    long views;
}
