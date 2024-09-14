package com.springboot.tutorials.jwt.repository;

import com.springboot.tutorials.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
