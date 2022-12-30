package com.example.demo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public abstract class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByUsername = userRepository.
                findUserByUsername(user.getUsername());

        if (userByUsername.isPresent()) {
            throw new IllegalStateException("username taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id" + userId + "does not exist"
            );
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String username) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exist"
                ));

        if (name != null && name.length() > 0 &&  !Objects.equals(user.getUsername(), name)) {
            user.setUsername(name);
        }

        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
    }


}
