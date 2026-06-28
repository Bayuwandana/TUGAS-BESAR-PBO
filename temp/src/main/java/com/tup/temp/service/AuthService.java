package com.tup.temp.service;

import org.springframework.stereotype.Service;

import com.tup.temp.entity.User;
import com.tup.temp.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {

    User user = userRepository.findByEmail(email)
            .orElse(null);

    if (user == null) {
        return null;
    }

    if (!user.getPassword().equals(password)) {
        return null;
    }

    return user;
}

}