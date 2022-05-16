package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject.R;

/**
 * @Author : Abdallah Fialah
 * ID : 1162193
 * Date : 30-4-2022
 * Android Development Course
 * We love heat Benzema
 * work station
 *
 */
// New Comment


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