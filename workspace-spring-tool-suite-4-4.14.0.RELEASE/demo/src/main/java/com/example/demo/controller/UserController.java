package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.user.User;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
