package com.example.NexEntryBackend.service;

import com.example.NexEntryBackend.model.User;
import com.example.NexEntryBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User loginGuard(String phone, String password) {

        User user = userRepository.findByPhone(phone);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        if (!user.getRole().equalsIgnoreCase("GUARD")) {
            throw new RuntimeException("Not a guard account");
        }

        return user;
    }
}