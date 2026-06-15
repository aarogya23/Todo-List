package com.todo.college.service;

import com.todo.college.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    private List<User> users = new ArrayList<>();

    private Long counter = 1L;

    public String signup(User user) {

        for (User existingUser : users) {

            if (existingUser.getEmail()
                    .equalsIgnoreCase(user.getEmail())) {

                return "Email already exists";
            }
        }

        user.setId(counter++);
        users.add(user);

        return "Signup Successful";
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