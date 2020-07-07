package com.androidmvvmdemo.auth.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidmvvmdemo.auth.helper.Validator;
import com.androidmvvmdemo.auth.model.User;

public class LoginViewModel extends ViewModel {
    // Holds user entered email
    private MutableLiveData<String> mEmail = new MutableLiveData<>();

    // Holds user entered password
    private MutableLiveData<String> mPassword = new MutableLiveData<>();

    // Observe this for getting notified in case of email validation error
    public MutableLiveData<String> emailError = new MutableLiveData<>();

    // Observe this for getting notified in case of password validation error
    public MutableLiveData<String> passwordError = new MutableLiveData<>();

    // Validation helper
    private Validator mValidator = new Validator();

    // Observe this for getting notified when user object is
    // fetched successfully after login
    public MutableLiveData<User> user = new MutableLiveData<>();

    /**
     * Set the user entered email to LiveData
     *
     * @param email email to set
     */
    public void setEmail(String email) {
        this.mEmail.setValue(email);
    }

    /**
     * Set the user entered password to LiveData
     *
     * @param password password to set
     */
    public void setPassword(String password) {
        this.mPassword.setValue(password);
    }

    /**
     * Login
     */
    public void login() {
        String email = this.mEmail.getValue();
        String password = this.mPassword.getValue();

        boolean isValid = true;

        // Check for email validation
        if (!mValidator.isValidEmail(email)) {
            emailError.setValue("Please enter valid email");
            isValid = false;
        } else {
            // Remove the previously set error if any as the validation has passed
            emailError.setValue(null);
        }

        // Check for password validation
        if (!mValidator.isValidPassword(password)) {
            passwordError.setValue("Please enter valid password");
            isValid = false;
        } else {
            // Remove the previously set error if any as the validation has passed
            passwordError.setValue(null);
        }

        if (isValid) {
            // In real world, the user object will be fetched
            // from remote source using API
            user.setValue(new User(email, "Sandip Soni"));
        }
    }
}
