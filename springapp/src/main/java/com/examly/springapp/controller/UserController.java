package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List <User> users=userRepository.findAll();
        if (users.isEmpty()){
            return new ResponseEntity<> (HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userRepository.findById(id).orElse(null);
    }
}
