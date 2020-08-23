package com.playmyabc.persistenceservice.domain.subdomain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer {
    AnswerType type;
    List<Integer> choiceAnswer;
    Boolean booleanAnswer;
    Content textAnswer;
    List<Content> justification;
    int scoring_points;
}
