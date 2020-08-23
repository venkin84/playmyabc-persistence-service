package com.playmyabc.persistenceservice.service;

import com.playmyabc.persistenceservice.domain.Group;
import com.playmyabc.persistenceservice.domain.User;
import com.playmyabc.persistenceservice.domain.subdomain.GroupType;
import com.playmyabc.persistenceservice.repository.GroupRepository;
import com.playmyabc.persistenceservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public GroupService (GroupRepository groupRepository,
                         UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    // Create Group with an Admin (Only an admin or admin candidate should be able to call this)
    // Must have an default system user that should be referred in all transient group types as admin
    //TODO Update method params based on the grpc interface model
    public Group createPersistentGroupWithAnAdmin (Group group, User user) {
        // TODO Validations & Error Handling
        // Validation:
            // id NULL
            // name NOTNULL
            // type PERSISTENT
            // admins NOTNULL
            // admins and members are in user collection
        if (group.getGroupType() == GroupType.PERSISTENT) {
            Optional<Group> existingGroup = groupRepository.findByName(group.getName());
            Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
            if (existingGroup.isPresent()) {
                if (existingGroup.get().getGroupType() == GroupType.PERSISTENT) {
                    if (existingUser.isPresent()) {
                        if(existingGroup.get().getAdmins().contains(existingUser.get())){
                            // TODO notify that this already existing
                            return null;
                        } else {
                            // TODO notify updated admin access for the existing group
                            List<User> adminsInExistingGroup = existingGroup.get().getAdmins();
                            adminsInExistingGroup.add(existingUser.get());
                            existingGroup.get().setAdmins(adminsInExistingGroup);
                            groupRepository.save(existingGroup.get());
                            return null;
                        }
                    } else {
                        // This is not the way this function should be used
                        // TODO the user needs to be registered first to add the user into the group
                        return null;
                    }
                } else {
                    // This is not the way this function should be used
                    // TODO the existing group type should be persistent to use this function.
                    return null;
                }
            } else {
                if (existingUser.isPresent()) {
                    // Ideal Scenario
                    return groupRepository.insert(group);
                } else {
                    // This is not the way this function should be used
                    // TODO the user needs to be registered first to add the user into the group
                    return null;
                }
            }
        } else {
            // This is not the way this function should be used
            // TODO the group type should be persistent to use this function.
            return null;
        }
    }

    // Read Group By Id
    public Group getGroupByID (String Id) {
        // TODO Validations & Error Handling
        return groupRepository.findById(Id).get();
    }

    // Read Group By Name
    public Group getGroupByName (String name) {
        // TODO Validations & Error Handling
        return groupRepository.findByName(name).get();
    }

    // Read all Groups by Type
    public List<Group> getGroupsByType (GroupType groupType) {
        // TODO Validations & Error Handling
        return groupRepository.findAllByGroupTypeOrderByName(groupType);
    }

    // Read Groups Name Like
    public List<Group> getGroupsByNameLike (String nameLike) {
        // TODO Validations & Error Handling
        return groupRepository.findAllByNameIsLikeOOrderByName(nameLike);
    }

    // Add Admin user to a group
    public Group addAdminToPersistentGroup (Group group, User user) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findByName(group.getName());
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingGroup.isPresent()) {
            if (existingGroup.get().getGroupType() == GroupType.PERSISTENT) {
                if (existingUser.isPresent()) {
                    if(existingGroup.get().getAdmins().contains(existingUser.get())){
                        // TODO notify that this already existing
                        return null;
                    } else {
                        // Ideal Scenario
                        List<User> adminsInExistingGroup = existingGroup.get().getAdmins();
                        adminsInExistingGroup.add(existingUser.get());
                        existingGroup.get().setAdmins(adminsInExistingGroup);
                        return groupRepository.save(existingGroup.get());
                    }
                } else {
                    // This is not the way this function should be used
                    // TODO the user needs to be registered first to add the user into the group
                    return null;
                }
            } else {
                // This is not the way this function should be used
                // TODO the existing group type should be persistent to use this function.
                return null;
            }
        } else {
            // This is not the way this function should be used
            // TODO the group should be there to use this function.
            return null;
        }
    }

    // Remove Admin user to a group.
    // Note there should be at least one Admin in a group
    public Group removeAdminFromPersistentGroup (Group group, User user) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findByName(group.getName());
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingGroup.isPresent()) {
            if (existingGroup.get().getGroupType() == GroupType.PERSISTENT) {
                if (existingUser.isPresent()) {
                    if(existingGroup.get().getAdmins().contains(existingUser.get())){
                        if (existingGroup.get().getAdmins().size()>1){
                            // Ideal Scenario
                            List<User> adminsInExistingGroup = existingGroup.get().getAdmins();
                            adminsInExistingGroup.remove(existingUser.get());
                            existingGroup.get().setAdmins(adminsInExistingGroup);
                            return groupRepository.save(existingGroup.get());
                        } else {
                            // TODO notify there should be atleast one admin in a group.
                            return null;
                        }
                    } else {
                        // TODO notify the user doesn't have admin access to this group
                        return null;
                    }
                } else {
                    // This is not the way this function should be used
                    // TODO the user needs to be registered first to add the user into the group
                    return null;
                }
            } else {
                // This is not the way this function should be used
                // TODO the existing group type should be persistent to use this function.
                return null;
            }
        } else {
            // This is not the way this function should be used
            // TODO the group should be there to use this function.
            return null;
        }
    }

    // Add Member to a group.
    public Group addMemberToGroup (Group group, User user) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findByName(group.getName());
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingGroup.isPresent()) {
            if (existingUser.isPresent()) {
                if(existingGroup.get().getMembers().contains(existingUser.get())){
                    // TODO notify that the user already existing as a member
                    return null;
                } else {
                    // Ideal Scenario
                    List<User> membersInExistingGroup = existingGroup.get().getMembers();
                    membersInExistingGroup.add(existingUser.get());
                    existingGroup.get().setMembers(membersInExistingGroup);
                    return groupRepository.save(existingGroup.get());
                }
            } else {
                // This is not the way this function should be used
                // TODO the user needs to be registered first to add the user into the group
                return null;
            }
        } else {
            // This is not the way this function should be used
            // TODO the group should be there to use this function.
            return null;
        }
    }

    //Remove Member from a Group
    public Group removeMemberFromGroup (Group group, User user) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findByName(group.getName());
        Optional<User> existingUser = userRepository.findByEmailAddress(user.getEmailAddress());
        if (existingGroup.isPresent()) {
            if (existingUser.isPresent()) {
                if(existingGroup.get().getMembers().contains(existingUser.get())){
                    // Ideal Scenario
                    List<User> membersInExistingGroup = existingGroup.get().getMembers();
                    membersInExistingGroup.remove(existingUser.get());
                    existingGroup.get().setMembers(membersInExistingGroup);
                    return groupRepository.save(existingGroup.get());
                } else {
                    // TODO notify the user is not member to this group
                    return null;
                }
            } else {
                // This is not the way this function should be used
                // TODO the user needs to be registered first to add the user into the group
                return null;
            }
        } else {
            // This is not the way this function should be used
            // TODO the group should be there to use this function.
            return null;
        }
    }

    // Update Group Name
    public Group updateGroupName (String groupId, String groupName) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findById(groupId);
        if (existingGroup.isPresent()) {
            existingGroup.get().setName(groupName);
            return groupRepository.save(existingGroup.get());
        } else {
            // TODO notify that the group is not there to update
            return null;
        }
    }

    // Delete a Group
    // This should be done only by the admin user.
    // Service using this should ensure the authorization for the same.
    public boolean deleteGroup (Group group) {
        // TODO Validations & Error Handling
        Optional<Group> existingGroup = groupRepository.findByName(group.getName());
        if (existingGroup.isPresent()) {
            groupRepository.delete(existingGroup.get());
            return true;
        } else {
            // TODO notify that the group is not there to delete
            return false;
        }
    }
}
