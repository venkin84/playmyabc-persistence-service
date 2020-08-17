package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.Answer;
import com.playmyabc.persistenceservice.domain.submodels.Comments;
import com.playmyabc.persistenceservice.domain.submodels.Question;

import java.util.List;

public class QuestionUnit {
    String id;
    Question question;
    Answer answer;
    List<Comments> authorGroupComments;
    int likes;
    int dislikes;
    List<Comments> userComments;
    int questionUnitId;
    int version;
}
