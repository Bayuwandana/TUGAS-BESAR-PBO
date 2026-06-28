package com.tup.temp.controller;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.entity.User;
import com.tup.temp.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return authService.login(
                user.getEmail(),
                user.getPassword()
        );

    }
}