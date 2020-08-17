package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.GroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Group {
    @Id
    String id;

    @Indexed
    String name;

    GroupType groupType;
    LocalDateTime createdOn;
    @DBRef
    List<User> admins;
    @DBRef
    List<User> members;
}
