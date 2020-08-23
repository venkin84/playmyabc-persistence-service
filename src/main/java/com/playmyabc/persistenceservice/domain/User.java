package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.subdomain.IdentityProvider;
import com.playmyabc.persistenceservice.domain.subdomain.RegistrationStatus;
import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document (collection = "users")
public class User {
    @Id
    String id;

    String firstName;
    String lastName;

    Binary image;

    @Indexed (unique = true)
    String emailAddress;
    IdentityProvider identityProvider;

    @CreatedDate
    LocalDateTime registeredOn;
    RegistrationStatus registrationStatus;
    LocalDateTime unregisteredOn;
    LocalDateTime reregisteredOn;
    @LastModifiedDate
    LocalDateTime lastModifiedOn;
}
