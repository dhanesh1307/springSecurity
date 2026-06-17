package com.example.usersecurity.exception;

import org.springframework.stereotype.Component;


@Component
public class UserNameIsNotFoundException extends  RuntimeException{

  public UserNameIsNotFoundException(String e)
  {
      super(e);
  }

    public UserNameIsNotFoundException() {
    }
}
