package com.androidmvvmdemo.auth.helper;

import android.util.Patterns;

public class Validator {
    public boolean isValidEmail(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() > 3;
    }
}
