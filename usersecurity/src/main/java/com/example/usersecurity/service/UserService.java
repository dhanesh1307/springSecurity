package com.example.usersecurity.service;

import com.example.usersecurity.enitity.UserDto;
import com.example.usersecurity.enitity.Users;
import com.example.usersecurity.exception.UserNameIsNotFoundException;
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
    public void registerUser(Users users) throws UserNameIsNotFoundException {
        users.setRole("User");
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        if(userRepository.existsByName(users.getName())) {
            throw new UserNameIsNotFoundException("Username already exists");
        }

        userRepository.save(users);
    }

    public UserDto getUserDetails(String name) {

        Users users=userRepository.findByUsersName(name);
        return new UserDto(users.getUsername(), users.getUserId(), users.getRole());

    }

    public void deleteUser(Users users) {
        userRepository.delete(users);
    }
}
