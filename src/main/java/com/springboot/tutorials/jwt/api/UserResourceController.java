package com.springboot.tutorials.jwt.api;

import com.springboot.tutorials.jwt.domain.Role;
import com.springboot.tutorials.jwt.domain.RoleToUserForm;
import com.springboot.tutorials.jwt.domain.User;
import com.springboot.tutorials.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserResourceController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        String uriPath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString();
        URI uri = URI.create(uriPath);
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role) {
        String uriPath = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString();
        URI uri = URI.create(uriPath);
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/roles/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
