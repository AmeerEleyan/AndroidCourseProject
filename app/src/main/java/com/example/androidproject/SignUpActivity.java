package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * @Author : Abdallah Fialah
 * ID : 1162193
 * Date : 30-4-2022
 * Android Development Course
 * We love you Benzema
 * not work station
 *
 */


public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.log_in_txt).setOnClickListener(
                v->{
                    startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                    //not work station
                }
        );
    }
}