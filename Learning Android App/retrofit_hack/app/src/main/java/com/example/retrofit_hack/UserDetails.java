package com.example.retrofit_hack;

public class UserDetails {

    private String id;
    private String password;

    public UserDetails(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

