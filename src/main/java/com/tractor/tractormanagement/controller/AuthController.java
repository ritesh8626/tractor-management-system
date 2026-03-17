package com.tractor.tractormanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tractor.tractormanagement.model.User;
import com.tractor.tractormanagement.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        if(existing.isPresent()){
            return "Email already exists";
        }

        userRepository.save(user);
        return "Registered Successfully";
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        if(existing.isPresent()){

            User dbUser = existing.get();

            if(dbUser.getPassword().equals(user.getPassword())){

                // return role for redirect
                return dbUser.getRole();
            }
        }

        return "Invalid";
    }
}