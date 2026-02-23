package com.tractor.tractormanagement.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tractor.tractormanagement.model.User;
import com.tractor.tractormanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {

        return userRepository.findByEmail(loginUser.getEmail())
                .filter(user -> user.getPassword().equals(loginUser.getPassword()))
                .map(user -> "Login Successful")
                .orElse("Invalid Credentials");
    }
}