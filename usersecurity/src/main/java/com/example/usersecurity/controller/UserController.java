package com.example.usersecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @GetMapping("/")
    public String healthCheck()
    {
      return "running successfully";
    }
}
