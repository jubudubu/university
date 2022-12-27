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
            User mariam = new User(
                    "Mariam",
                    "mariam.jones@gmail.com",
                    LocalDate.of(2000, 1, 5)
            );

            User alex = new User(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, 1, 5)
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );

        };
    }
}
