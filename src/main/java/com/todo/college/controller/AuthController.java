package com.todo.college.controller;

import com.todo.college.model.User;
import com.todo.college.service.AuthService;
import com.todo.college.service.TokenCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   private AuthService authService;

   @Autowired
   private TokenCreation tokenCreation;

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

    @PutMapping("/update/{id}")

    public String update(@PathVariable int id, @RequestBody User user) {
        return  authService.updateUser((long) id,user);
    }

    @DeleteMapping("/{id}")

    public String delete(@PathVariable int id) {
        return  authService.deleteUser((long) id);
    }

    @GetMapping("/token")
    public String generateToken() {
        return tokenCreation.createToken();
    }
}
