package com.example.demo.role;

import com.example.demo.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@Configuration
@ComponentScan("com.example.demo.user")
@EnableJpaRepositories(basePackages = {"com.example.demo.role", "com.example.demo.user"})
public class UserServiceApplication {

    @Bean
    CommandLineRunner run(RoleUserService roleUserService) {
        return args -> {
            roleUserService.saveRole(new Role(null, "ROLE_USER"));
            roleUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            roleUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            roleUserService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));

            roleUserService.addRoleToUser("john", "ROLE_USER");
        };
    }
}