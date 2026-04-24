package com.example.NexEntryBackend.controller;

import com.example.NexEntryBackend.model.LoginRequest;
import com.example.NexEntryBackend.model.User;
import com.example.NexEntryBackend.repository.UserRepository;
import com.example.NexEntryBackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/guard-login")
    public User guardLogin(@RequestBody LoginRequest request) {
        return authService.loginGuard(
                request.getPhone(),
                request.getPassword()
        );
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}