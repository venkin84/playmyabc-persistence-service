package com.playmyabc.persistenceservice.domain.subdomain;

import java.util.List;

public class Question {
    List<Content> questionStatement;
    List<Content> choices;
    QuestionType type;
}
