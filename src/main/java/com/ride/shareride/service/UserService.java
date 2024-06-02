package com.ride.shareride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.shareride.entity.User;
import com.ride.shareride.repositrory.UserRepository;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Implement registration logic, e.g., hashing password, saving user to database
        return userRepository.save(user);
    }

    // public String loginUser(LoginRequest loginRequest) {
    //     // Implement authentication logic, e.g., validating user credentials, generating JWT token
    //     Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
    //     if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
    //         return "generated-jwt-token"; // Replace with actual token generation logic
    //     } else {
    //         throw new RuntimeException("Invalid credentials");
    //     }
    // }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

