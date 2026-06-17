package com.example.usersecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNameIsNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNameIsNotFoundException e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
    }
}
