package com.example.demo.user;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    UserService userService;

//    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public String hello() {
        return "blabla";
    }
//
//    @GetMapping
//    public List<String> helloList() {
//        return (List.of("Hello", "World"));
//    }

//    @PostMapping
//    public void registerNewUser(
//            @RequestParam String name,
//            @RequestParam Long pass,
//            @RequestParam Role role
//    ) {
//        User user = new User(name, pass, role);
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
            @RequestParam(required = false) String username
    ) {
        System.out.println("name: " + name + "username" + username);
        userService.updateUser(userId, name, username);
    }
}

