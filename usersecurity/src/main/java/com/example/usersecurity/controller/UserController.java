package com.example.usersecurity.controller;

import com.example.usersecurity.enitity.Users;
import com.example.usersecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String healthCheck()
    {
      return "running successfully";
    }

    @PostMapping("/register")
    public void userRegister(@RequestBody Users users)
    {
        userService.registerUser(users);
    }
}
