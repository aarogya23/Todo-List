package com.todo.college.controller;

import com.todo.college.model.User;
import com.todo.college.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthService authService;


    // ================= SIGNUP =================

    @PostMapping("/signup")

    public String signup(

            @RequestBody User user){

        return authService.signup(
                user
        );
    }


    // ================= LOGIN =================

    @PostMapping("/login")

    public String login(

            @RequestBody User user){

        return authService.login(
                user
        );
    }


    // ================= LOGOUT =================

    @PostMapping("/logout")

    public String logout(

            @RequestHeader("token")

            String token){

        return authService.logout(
                token
        );
    }


    // ================= GET ALL USERS =================

    @GetMapping("/users")

    public List<User> getAllUsers(){

        return authService.getAllUsers();
    }


    // ================= GET USER BY ID =================

    @GetMapping("/{id}")

    public User getUserById(

            @PathVariable Long id){

        return authService.getUserById(
                id
        );
    }


    // ================= UPDATE USER =================

    @PutMapping("/update/{id}")

    public String updateUser(

            @PathVariable Long id,

            @RequestBody User user){

        return authService.updateUser(

                id,

                user
        );
    }


    // ================= DELETE USER =================

    @DeleteMapping("/{id}")

    public String deleteUser(

            @PathVariable Long id){

        return authService.deleteUser(
                id
        );
    }

}