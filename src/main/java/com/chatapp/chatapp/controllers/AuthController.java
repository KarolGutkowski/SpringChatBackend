package com.chatapp.chatapp.controllers;

import com.chatapp.chatapp.entities.LoginResponse;
import com.chatapp.chatapp.entities.User;
import com.chatapp.chatapp.services.JwtService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    public AuthController(@Autowired JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .build();

        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token, jwtService.getExpirationTime());
    }




}
