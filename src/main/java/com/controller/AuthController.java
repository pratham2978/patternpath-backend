package com.patternpath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.patternpath.model.User;
import com.patternpath.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (repo.findByEmail(user.getEmail()) != null) {
            return "Email already exists";
        }
        repo.save(user);
        return "Registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = repo.findByEmail(user.getEmail());

        if (dbUser == null)
            return "User not found";

        if (!dbUser.getPassword().equals(user.getPassword()))
            return "Wrong password";

        return "Login successful";
    }
}
