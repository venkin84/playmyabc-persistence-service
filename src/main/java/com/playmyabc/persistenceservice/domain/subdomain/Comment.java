package com.playmyabc.persistenceservice.domain.subdomain;

import java.util.List;

public class Comment {
    int id;  // TODO find a way to auto-generate the sequence
    String comment;
    List<Comment> replies;
    long likes;
    long dislikes;
}
