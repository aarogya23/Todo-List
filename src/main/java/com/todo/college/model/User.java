package com.todo.college.model;


public class User {


    private Long id;
    private String name;
    private String password;
    private String email;
    private String token;


    private User(){}

    private User(Long id, String name, String password, String email, String token) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.token = token;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
