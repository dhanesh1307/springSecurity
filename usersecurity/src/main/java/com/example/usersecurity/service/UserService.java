package com.example.usersecurity.service;

import com.example.usersecurity.enitity.Users;
import com.example.usersecurity.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
    public void registerUser(Users users) {
        users.setRole("User");
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        if(userRepository.existsByName(users.getName())) {
            throw new UsernameNotFoundException("Username already exists");
        }

        userRepository.save(users);
    }
}
