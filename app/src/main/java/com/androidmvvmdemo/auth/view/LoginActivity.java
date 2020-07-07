package com.androidmvvmdemo.auth.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.androidmvvmdemo.R;
import com.androidmvvmdemo.auth.model.User;
import com.androidmvvmdemo.auth.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        init();
    }

    private void init() {
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login();
            }
        });

        // observe for errors
        loginViewModel.emailError.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etEmail.setError(s);
            }
        });

        loginViewModel.passwordError.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etPassword.setError(s);
            }
        });

        // observe for successfully getting user data
        loginViewModel.user.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Toast.makeText(LoginActivity.this, "Login successful...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
