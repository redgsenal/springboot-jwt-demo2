package com.springboot.tutorials.jwt;

import com.springboot.tutorials.jwt.domain.Role;
import com.springboot.tutorials.jwt.domain.User;
import com.springboot.tutorials.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        // this command line runner will run after the application has initialized
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John", "Doe", "jj@test.com", "john", "test123", new ArrayList<>()));
            userService.saveUser(new User(null, "Kate", "Mills", "km@test.com", "kate", "test123", new ArrayList<>()));
            userService.saveUser(new User(null, "Dan", "Lim", "dl@test.com", "dan", "test123", new ArrayList<>()));
            userService.saveUser(new User(null, "Mike", "Tan", "mt@test.com", "mike", "test123", new ArrayList<>()));
            userService.saveUser(new User(null, "Zoe", "Pan", "zp@test.com", "zoe", "test123", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("kate", "ROLE_USER");
            userService.addRoleToUser("kate", "ROLE_MANAGER");
            userService.addRoleToUser("dan", "ROLE_USER");
            userService.addRoleToUser("dan", "ROLE_MANAGER");
            userService.addRoleToUser("dan", "ROLE_ADMIN");
            userService.addRoleToUser("mike", "ROLE_MANAGER");
            userService.addRoleToUser("mike", "ROLE_ADMIN");
            userService.addRoleToUser("zoe", "ROLE_USER");
            userService.addRoleToUser("zoe", "ROLE_ADMIN");
            userService.addRoleToUser("zoe", "ROLE_SUPER_ADMIN");
        };
    }
}
