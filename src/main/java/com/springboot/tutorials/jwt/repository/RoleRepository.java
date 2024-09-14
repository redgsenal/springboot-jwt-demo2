package com.springboot.tutorials.jwt.repository;

import com.springboot.tutorials.jwt.domain.Role;
import com.springboot.tutorials.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
