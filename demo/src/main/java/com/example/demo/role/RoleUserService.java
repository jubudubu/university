package com.example.demo.role;

import com.example.demo.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleUserService {
    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}
