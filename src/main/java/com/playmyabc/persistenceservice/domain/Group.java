package com.playmyabc.persistenceservice.domain;

import com.mongodb.lang.NonNull;
import com.playmyabc.persistenceservice.domain.subdomain.GroupType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document (collection = "groups")
public class Group {
    @Id
    String id;

    @Indexed (unique = true) // TODO to confirm if the name field should be unique or not.
    String name;
    GroupType groupType;

    @DBRef
    List<User> admins;
    @DBRef
    List<User> members;

    @CreatedDate
    LocalDateTime createdOn;
    @LastModifiedDate
    LocalDateTime lastModifiedOn;
}
