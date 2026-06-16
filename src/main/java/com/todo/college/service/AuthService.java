package com.todo.college.service;

import com.todo.college.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private TokenCreation tokenCreation;

    private List<User> users = new ArrayList<>();

    private Long counter = 1L;

    public String signup(User user) {



            for (User existingUser : users) {

                if (existingUser.getEmail() != null
                        && user.getEmail() != null
                        && existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {

                    return "Email already exists";
                }
            }


        user.setId(counter++);

        // generate token here
        String token = tokenCreation.createToken();
        user.setToken(token);

        users.add(user);

        System.out.println(user);

        return "Signup Successful\nUser: "
                + user.getName()
                + "\nEmail: " + user.getEmail()
                + "\nToken: " + user.getToken();


    }

    public List<User> getAllUsers() {

        return users;
    }

    public String login(User user) {

        for (User existingUser : users) {

            if (existingUser.getEmail().equalsIgnoreCase(user.getEmail()) && existingUser.getPassword()
                            .equals(user.getPassword())) {

                return "Login Successful";
            }
        }

        return "Invalid email or password";
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