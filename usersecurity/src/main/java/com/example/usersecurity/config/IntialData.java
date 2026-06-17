package com.example.usersecurity.config;

import com.example.usersecurity.enitity.Users;
import com.example.usersecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class IntialData {

    @Bean
    public CommandLineRunner createInitialUser(UserRepository userRepository, PasswordEncoder passwordEncoder)

    {
return args -> {
    if(!(userRepository.existsByName("admin")))
    {
        Users users=new Users();
        users.setName("admin");
        users.setPassword(passwordEncoder.encode("admin"));
        users.setRole("ADMIN");

        System.out.println("created admin");

        userRepository.save(users);
    }
};
    }
}
