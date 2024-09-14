package com.springboot.tutorials.jwt.domain;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String userName;
    private String roleName;
}
