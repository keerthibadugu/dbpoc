package com.db.poc.dbpoc.controller;

import com.db.poc.dbpoc.domain.User;
import com.db.poc.dbpoc.repository.UserRepository;
import com.db.poc.dbpoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody  User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.ok(user1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted Successfully!");
    }

}
