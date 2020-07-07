package com.androidmvvmdemo.auth.model;

public class User {
    private String email;
    private String fullName;

    public User(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
