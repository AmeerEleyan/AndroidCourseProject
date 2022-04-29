package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * @author: Amir Eleyan
 * ID: 1191076
 * Date: 30/4/2022      1:30 AM
 * Android Course
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.sign_up_text).setOnClickListener(
                v->{
                    startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                }
        );
        findViewById(R.id.forget_password_text).setOnClickListener(
                v->{
                    startActivity(new Intent(LoginActivity.this,ForgetPassword.class));
                }
        );
    }

}