package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.subdomain.Answer;
import com.playmyabc.persistenceservice.domain.subdomain.Comment;
import com.playmyabc.persistenceservice.domain.subdomain.Question;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

// TODO update annotations for the sub fields
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document (collection = "question_units")
public class QuestionUnit {
    @Id
    private String id;

    private Question question;
    private Answer answer;

    private List<Comment> authorGroupComments;
    private List<Comment> userComments;
    private long likes;
    private long dislikes;

    private long questionUnitId;
    private long version;

    @CreatedDate
    private LocalDateTime createdOn;
    @LastModifiedDate
    LocalDateTime lastModifiedOn;
}
