package com.example.usersecurity.repository;

import com.example.usersecurity.enitity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
