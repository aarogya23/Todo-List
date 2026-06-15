package com.todo.college.controller;

import com.todo.college.model.User;
import com.todo.college.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return authService.signup(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return authService.login(user);
    }

    // ---------------- UPDATE ----------------
    public String updateUser(Long id, User updatedUser) {

        for (User user : users) {

            if (user.getId().equals(id)) {

                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());

                return "User updated successfully";
            }
        }

        return "User not found";
    }

    // ---------------- DELETE ----------------
    public String deleteUser(Long id) {

        for (User user : users) {

            if (user.getId().equals(id)) {

                users.remove(user);
                return "User deleted successfully";
            }
        }

        return "User not found";
    }
}
