package com.example.usersecurity.repository;

import com.example.usersecurity.enitity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    boolean existsByName(String name);

    UserDetails findByName(String name);

    @Query("SELECT u FROM Users u WHERE u.name=?1")
    Users findByUsersName(String name);
}
