package com.playmyabc.persistenceservice.domain.submodels;

import java.util.List;

public class Comment {
    int id;
    String comment;
    List<Comment> replies;
    long likes;
    long dislikes;
}
