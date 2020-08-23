package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.User;
import com.playmyabc.persistenceservice.domain.subdomain.IdentityProvider;
import com.playmyabc.persistenceservice.domain.subdomain.RegistrationStatus;
import com.playmyabc.persistenceservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    // Register new User or Re-register existing User
    //TODO Update method params based on the grpc interface model
    public User registerUser(User user) {
        // TODO Validations & Error Handling
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()){
            user.setId(existingUser.get().getId());
            user.setReregisteredOn(LocalDateTime.now());
            return userRepository.save(user);
        } else {
            return userRepository.insert(user);
        }
    }

    // Get user by ID
    public User getUserByID(String Id) {
        // TODO Validations & Error Handling
        return userRepository.findById(Id).get();
    }

    // Get user by Email Address
    public User getUserByEmailAddress(String emailAddr) {
        // TODO Validations & Error Handling
        return userRepository.findByEmailAddress(emailAddr).get();
    }

    // Get users by Registration Status
    public List<User> getUsersByRegistrationStatus(RegistrationStatus registrationStatus) {
        // TODO Validations & Error Handling
        return userRepository.findAllByRegistrationStatusOrderByRegisteredOn(registrationStatus);
    }

    // Get users by Identity Provider
    public List<User> getUsersByIdentityProvider(IdentityProvider identityProvider) {
        // TODO Validations & Error Handling
        return userRepository.findAllByIdentityProviderOrderByRegisteredOn(identityProvider);
    }

    // Update User Info (email address, identity provider, first name, last name or image)
    //TODO Update method params based on the grpc interface model
    public User updateUserInfo (User user) {
        // TODO Validations & Error Handling
        return userRepository.save(user);
    }

    // Unregister user
    //TODO Update method params based on the grpc interface model
    public boolean unregisterUser (User user) {
        // TODO Validations & Error Handling
        // Modify the find by criteria to ID based on input to the service
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()){
            existingUser.get().setRegistrationStatus(RegistrationStatus.UNREGISTERED);
            existingUser.get().setUnregisteredOn(LocalDateTime.now());
            userRepository.save(existingUser.get());
            return true;
        } else {
            return false;
        }
    }

    // Delete User
    //TODO Update method params based on the grpc interface model
    public boolean deleteUser (User user) {
        // TODO Validations & Error Handling
        // Modify the find by criteria to ID based on input to the service
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingUser.isPresent()){
            userRepository.delete(existingUser.get());
            return true;
        } else {
            return false;
        }
    }
}
