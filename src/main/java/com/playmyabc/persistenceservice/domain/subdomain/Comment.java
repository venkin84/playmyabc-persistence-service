package com.playmyabc.persistenceservice.domain.subdomain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    int id;  // TODO find a way to auto-generate the sequence
    String comment;
    List<Comment> replies;
    long likes;
    long dislikes;
}
