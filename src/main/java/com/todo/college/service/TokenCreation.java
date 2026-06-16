package com.todo.college.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenCreation {

    private static final String CHARS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int TOKEN_LENGTH = 50;

    public String createToken() {

        Random random = new Random();

        StringBuilder token = new StringBuilder();

        for (int i = 0; i < TOKEN_LENGTH; i++) {

            int index = random.nextInt(CHARS.length());

            token.append(CHARS.charAt(index));
        }

        return token.toString();
    }
}