package com.chatapp.chatapp.controllers;

import com.chatapp.chatapp.entities.Authority;
import com.chatapp.chatapp.entities.User;
import com.chatapp.chatapp.entities.UserRegistration;
import com.chatapp.chatapp.repositories.AuthorityRepository;
import com.chatapp.chatapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    private final String roleUser = "ROLE_USER";

    public RegistrationController(@Autowired UserRepository userRepository,
                                  @Autowired PasswordEncoder passwordEncoder,
                                  @Autowired AuthorityRepository authorityRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;


        var user_role_authority = new Authority();
        user_role_authority.setName(roleUser);
        this.authorityRepository.save(user_role_authority);
    }

    @PostMapping
    public User register(@RequestBody UserRegistration userRegistration) {
        var userRoleAuthority = authorityRepository.getAuthorityByAuthorityName(roleUser);

        List<Authority> userRole = List.of(userRoleAuthority);

        var user = new User(userRegistration.getUsername(), passwordEncoder.encode(userRegistration.getPassword()), userRole);

        return userRepository.save(user);
    }
}
