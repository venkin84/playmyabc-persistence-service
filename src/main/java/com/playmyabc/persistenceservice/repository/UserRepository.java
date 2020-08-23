package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.User;
import com.playmyabc.persistenceservice.domain.subdomain.IdentityProvider;
import com.playmyabc.persistenceservice.domain.subdomain.RegistrationStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmailAddress(String emailAddr);
    List<User> findAllByRegistrationStatusOrderByRegisteredOn(RegistrationStatus registrationStatus);
    List<User> findAllByIdentityProviderOrderByRegisteredOn(IdentityProvider identityProvider);
}
