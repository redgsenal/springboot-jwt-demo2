package com.springboot.tutorials.jwt.service;

import com.springboot.tutorials.jwt.domain.Role;
import com.springboot.tutorials.jwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
