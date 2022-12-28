package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User admin = new User(
                    1L,
                    "Admin",
                    "admin@admin.com",
                    LocalDate.now(),
                    123123123L,
                    Role.ADMIN
            );

            repository.saveAll(
                    List.of(admin)
            );

        };
    }
}
