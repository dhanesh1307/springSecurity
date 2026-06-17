package com.example.usersecurity.controller;

import com.example.usersecurity.enitity.UserDto;
import com.example.usersecurity.enitity.Users;
import com.example.usersecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> userRegister(@RequestBody Users users)
    {

        userService.registerUser(users);
        return ResponseEntity.ok("registered successfully "+users.getName());
    }

    @GetMapping("/login")
    public UserDto getUserDetails(Authentication authentication)
    {
        String name=authentication.getName();
       return  userService.getUserDetails(name);
    }

    @DeleteMapping("/delete")
    public String deleteUser(Authentication authentication)
    {
        Users users=(Users)authentication.getPrincipal();
        userService.deleteUser(users);
        return "Deleted user "+authentication.getName()+" successfully";
    }
}
