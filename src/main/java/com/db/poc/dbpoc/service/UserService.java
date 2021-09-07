package com.db.poc.dbpoc.service;

import com.db.poc.dbpoc.domain.User;
import com.db.poc.dbpoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private UserRepository userRepository;

    /**
     * Before Saving the entity verify, if the userName already exists.
     * if exists update the entity and save.
     *
     * And, publish into ActiveMQ destination: UserIngestionCompleted
     * @param user
     * @return
     */
    public User saveUser(User user) {
        User exists = userRepository.findByUserName(user.getUsername());
        if (exists == null) {
            // Create
            exists = user;
        } else {
            // Update
            exists.update(user);
        }

        User savedUser = userRepository.save(exists);
        if (savedUser != null) {
            jmsTemplate.convertAndSend("UserIngestionCompleted", savedUser);
        }

        return savedUser;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Delete the userById.
     * Once on deletion, publish into destination: UserDeletionCompleted
     * @param id
     */
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            jmsTemplate.convertAndSend("UserDeletionCompleted", user.get());
        }
    }
}
