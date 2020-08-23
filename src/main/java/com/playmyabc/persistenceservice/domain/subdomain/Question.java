package com.playmyabc.persistenceservice.domain.subdomain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
    List<Content> questionStatement;
    List<Content> choices;
    QuestionType type;
}
