package com.forum.forum.api;


import com.forum.forum.repository.UserRepository;
import com.forum.forum.service.UserService;
import com.forum.forum.model.User;
import com.forum.forum.service.annotations.Role;
import com.forum.forum.service.exception.UserNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.forum.forum.model.User.Role.ADMIN;
import static com.forum.forum.model.User.Role.USER;

import java.util.Optional;

@RestController
//for testing purposes
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserApiController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    //@Role({USER, ADMIN})
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }

    }
    //@Role({USER, ADMIN})
    @GetMapping("{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        try {
            return ResponseEntity.ok(userService.getUserByUserName(userName));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //@Role({USER, ADMIN})
    @GetMapping("/profile")
    public ResponseEntity<User> getCurrentUser() {
        try {
            return ResponseEntity.ok(userService.getUser());
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        System.out.println("Login...");
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("Registering user...");
        try {
            return ResponseEntity.ok(userService.register(user));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
