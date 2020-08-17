package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.Answer;
import com.playmyabc.persistenceservice.domain.submodels.Comment;
import com.playmyabc.persistenceservice.domain.submodels.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

// TODO update annotations for the sub fields
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class QuestionUnit {
    @Id
    String id;

    Question question;
    Answer answer;

    List<Comment> authorGroupComments;
    List<Comment> userComments;
    long likes;
    long dislikes;

    int questionUnitId; // TODO find a way to auto-generate the sequence
    int version;

    @CreatedDate
    LocalDateTime createdOn;
}
