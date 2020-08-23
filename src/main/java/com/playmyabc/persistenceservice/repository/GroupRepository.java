package com.playmyabc.persistenceservice.repository;

import com.playmyabc.persistenceservice.domain.Group;
import com.playmyabc.persistenceservice.domain.subdomain.GroupType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends MongoRepository<Group, String> {
    Optional<Group> findByName(String groupName);
    List<Group> findAllByGroupTypeOrderByName(GroupType groupType);
    List<Group> findAllByNameIsLikeOOrderByName(String nameLike);
}
