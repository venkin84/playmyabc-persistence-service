package com.playmyabc.persistenceservice.domain;

import com.playmyabc.persistenceservice.domain.submodels.IdentityProvider;
import com.playmyabc.persistenceservice.domain.submodels.RegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    String id;

    String firstName;
    String lastName;

    @Indexed (unique = true)
    String emailAddress;

    Binary image;
    //    Service Implementation for sending receiving photos
//    public String addPhoto(String title, MultipartFile file) throws IOException {
//        Photo photo = new Photo(title);
//        photo.setImage(
//                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
//        photo = photoRepo.insert(photo); return photo.getId();
//    }
//
//    public Photo getPhoto(String id) {
//        return photoRepo.findById(id).get();
//    }
    LocalDateTime registeredOn;
    RegistrationStatus registrationStatus;
    LocalDateTime unregisteredOn;
    IdentityProvider identityProvider;
}
