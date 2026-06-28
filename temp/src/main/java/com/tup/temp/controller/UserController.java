package com.tup.temp.controller;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.entity.User;
import com.tup.temp.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PutMapping("/update/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {

        User user =
                userRepository.findById(id).orElseThrow();

        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }
    
}