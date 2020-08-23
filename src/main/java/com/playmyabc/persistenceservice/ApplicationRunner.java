package com.playmyabc.persistenceservice;

import com.playmyabc.persistenceservice.domain.Group;
import com.playmyabc.persistenceservice.domain.QuestionUnit;
import com.playmyabc.persistenceservice.domain.User;
import com.playmyabc.persistenceservice.domain.subdomain.*;
import com.playmyabc.persistenceservice.repository.GroupRepository;
import com.playmyabc.persistenceservice.repository.QuestionUnitRepository;
import com.playmyabc.persistenceservice.repository.UserRepository;
import com.playmyabc.persistenceservice.service.GroupService;
import com.playmyabc.persistenceservice.service.SequencerService;
import com.playmyabc.persistenceservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private QuestionUnitRepository questionUnitRepository;
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    private SequencerService sequencerService;
    private UserService userService;
    private GroupService groupService;

    @Autowired
    public ApplicationRunner(SequencerService sequencerService,
                             QuestionUnitRepository questionUnitRepository,
                             UserRepository userRepository,
                             GroupRepository groupRepository,
                             UserService userService,
                             GroupService groupService) {
        this.sequencerService = sequencerService;
        this.questionUnitRepository = questionUnitRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.userService = userService;
        this.groupService = groupService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Started... ");

//        // Test 01
//        QuestionUnit questionUnit1 = new QuestionUnit();
//        questionUnit1.setQuestionUnitId(sequencerService.getNextSeqNumber("QUnitSeq"));
//        Content questionStatement = new Content();
//        questionStatement.setTextContent("What is my official name?");
//        Content questionChoiceA = new Content();
//        questionChoiceA.setTextContent("Venkataraman N");
//        Content questionChoiceB = new Content();
//        questionChoiceB.setTextContent("Cheenu");
//        Question question = new Question();
//        question.setQuestionStatement(List.of(questionStatement));
//        question.setChoices(List.of(questionChoiceA, questionChoiceB));
//        questionUnit1.setQuestion(question);
//        Answer answer = new Answer();
//        answer.setChoiceAnswer(List.of(1));
//        answer.setScoring_points(1);
//        Content answerJustification = new Content();
//        answerJustification.setTextContent("I know since it is my Name...");
//        answer.setJustification(List.of(answerJustification));
//        questionUnit1.setAnswer(answer);
//        questionUnitRepository.insert(questionUnit1);
//        System.out.println("Inserting Question Unit...");

//        // Test 02
//        User user1 = new User();
//        user1.setEmailAddress("myaddr1@gmail.com");
//        user1.setFirstName("Venkat");
//        user1.setLastName("N");
//        user1.setRegistrationStatus(RegistrationStatus.REGISTERED);
//        user1.setIdentityProvider(IdentityProvider.GOOGLE);
//
//        User user2 = new User();
//        user2.setEmailAddress("myaddr2@gmail.com");
//        user2.setFirstName("Cheenu");
//        user2.setLastName("N");
//        user2.setRegistrationStatus(RegistrationStatus.REGISTERED);
//        user2.setIdentityProvider(IdentityProvider.GOOGLE);
//
//        userRepository.insert(List.of(user1,user2));
//
//        Group group1 = new Group();
//        group1.setName("My Group");
//        group1.setGroupType(GroupType.PERSISTENT);
//        User adminUser = userRepository.findByEmailAddress("myaddr1@gmail.com").get();
//        group1.setAdmins(List.of(adminUser));
//
//        groupRepository.insert(group1);
//
//        Group group = groupRepository.findById("5f41709165f43703402cc639").get();
//        List<User> adminUsersOfGroup = group.getAdmins();
//        System.out.println("One of the admins in the group is " + adminUsersOfGroup.get(0).getFirstName());

        // Test 03
        List<User> googleUsers = userService.getUsersByIdentityProvider(IdentityProvider.GOOGLE);
        for (User user : googleUsers){
            System.out.println("User: " + user.getFirstName());
        }

        List<Group> persistentGroups = groupService.getGroupsByType(GroupType.PERSISTENT);
        for (Group group : persistentGroups){
            System.out.println("Group: " + group.getName());
        }
    }
}
