package com.playmyabc.persistenceservice.domain.subdomain;

import java.util.List;

public class Answer {
    AnswerType type;
    int choiceAnswer;
    Boolean booleanAnswer;
    Content textAnswer;
    List<Content> justification;
    int scoring_points;
}
