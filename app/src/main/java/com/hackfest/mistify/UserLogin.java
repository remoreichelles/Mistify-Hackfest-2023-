package com.hackfest.mistify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserLogin extends AppCompatActivity {

    Button btnLoginEmail;

    TextInputLayout emailContainer,passwordContainer;
    TextInputEditText emailEditTxt, passwordEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        emailContainer = findViewById(R.id.emailContainer);
        passwordContainer = findViewById(R.id.passwordContainer);
        emailEditTxt = findViewById(R.id.emailEditTxt);
        passwordEditTxt = findViewById(R.id.passwordEditTxt);
        btnLoginEmail = findViewById(R.id.btnAddEmail);


        btnLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailEditTxt.getText().toString();
        String password = passwordEditTxt.getText().toString();

        if (TextUtils.isEmpty(email)) {
            emailEditTxt.setError("Email cannot be empty");
            emailEditTxt.requestFocus();
            emailContainer.setHelperText("*Required");
            return;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditTxt.setError("Please provide valid email");
            emailEditTxt.requestFocus();
            passwordEditTxt.setText("");
            return;
        } else if (TextUtils.isEmpty(password)) {
            passwordEditTxt.setError("Password cannot be empty");
            passwordEditTxt.requestFocus();
            passwordEditTxt.setText("");
            passwordContainer.setHelperText("*Required");
            return;
        } else {
            navigateToSecondActivity();

        }

    }

    // finish the current form, then open the next form
    void navigateToSecondActivity() {
        Intent intent = new Intent(UserLogin.this, MainMenu.class);
        startActivity(intent);
        finish();
    }
}