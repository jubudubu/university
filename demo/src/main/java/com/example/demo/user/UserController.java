package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {

    UsertService usertService;

//    @GetMapping
//    public String hello() {
//        return "blabla";
//    }
//
//    @GetMapping
//    public List<String> helloList() {
//        return (List.of("Hello", "World"));
//    }

    @PostMapping
    public void registerNewUser(
            @RequestParam String name,
            @RequestParam String dob,
            @RequestParam String email
    ) {
        User user = new User(name, email, LocalDate.parse(dob));
        usertService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        usertService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        System.out.println("name: " + name + "email" + email);
        usertService.updateUser(userId, name, email);
    }
}

