package com.todo.college.service;

import com.todo.college.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private TokenCreation tokenCreation;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private final List<User> users =
            new ArrayList<>();

    private Long counter = 1L;


    // ================= SIGNUP =================

    public String signup(User user) {

        if (user.getName() == null
                || user.getEmail() == null
                || user.getPassword() == null) {

            return "All fields are required";
        }

        for (User existingUser : users) {

            if (existingUser.getEmail() != null

                    &&

                    existingUser.getEmail()
                            .equalsIgnoreCase(
                                    user.getEmail()
                            )
            ) {

                return "Email already exists";
            }
        }

        user.setId(counter++);

        user.setPassword(

                encoder.encode(
                        user.getPassword()
                )
        );

        user.setToken(null);

        users.add(user);

        return user.getName() + " have successfully signuped in the application";
    }


    // ================= LOGIN =================

    public String login(User user) {

        if (user.getEmail() == null
                || user.getPassword() == null) {

            return "Email and Password required";
        }

        for (User existingUser : users) {

            if (existingUser.getEmail() != null

                    &&

                    existingUser.getEmail()
                            .equalsIgnoreCase(
                                    user.getEmail()
                            )

                    &&

                    encoder.matches(

                            user.getPassword(),

                            existingUser.getPassword()
                    )
            ) {

                String token =

                        tokenCreation
                                .createToken();

                existingUser.setToken(token);

                return "Login Successful\n\n"

                        + "Token : "

                        + token;
            }
        }

        return "Invalid email or password";
    }


    // ================= VALIDATE TOKEN =================

    public User validateUser(String token) {

        for (User user : users) {

            if (user.getToken() != null

                    &&

                    user.getToken()
                            .equals(token)
            ) {

                return user;
            }
        }

        return null;
    }


    // ================= GET USERS =================

    public List<User> getAllUsers() {

        return users;
    }


    // ================= GET USER BY ID =================

    public User getUserById(Long id) {

        for (User user : users) {

            if (user.getId().equals(id)) {

                return user;
            }
        }

        return null;
    }


    // ================= UPDATE USER =================

    public String updateUser(Long id,
                             User updatedUser) {

        for (User user : users) {

            if (user.getId().equals(id)) {

                user.setName(
                        updatedUser.getName()
                );

                user.setEmail(
                        updatedUser.getEmail()
                );

                if (updatedUser.getPassword() != null) {

                    user.setPassword(

                            encoder.encode(

                                    updatedUser.getPassword()
                            )
                    );
                }

                return "User updated successfully";
            }
        }

        return "User not found";
    }


    // ================= DELETE USER =================

    public String deleteUser(Long id) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId().equals(id)) {

                users.remove(i);

                return "User deleted successfully";
            }
        }

        return "User not found";
    }


    // ================= LOGOUT =================

    public String logout(String token) {

        User user = validateUser(token);

        if (user == null) {

            return "Invalid token";
        }

        user.setToken(null);

        return "Logout Successful";
    }

}