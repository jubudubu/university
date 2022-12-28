package com.example.demo.user;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/api/v1/user")
public class UserController {

    UserService userService;

//    @GetMapping
//    public String hello() {
//        return "blabla";
//    }
//
//    @GetMapping
//    public List<String> helloList() {
//        return (List.of("Hello", "World"));
//    }

//    @PostMapping
//    public void registerNewUser(
//            @RequestParam String name,
//            @RequestParam String dob,
//            @RequestParam String email,
//            @RequestParam Long pass,
//            @RequestParam Role role
//    ) {
//        User user = new User(name, email, LocalDate.parse(dob), pass, role);
//        userService.addNewUser(user);
//    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        System.out.println("name: " + name + "email" + email);
        userService.updateUser(userId, name, email);
    }
}

