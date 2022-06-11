package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidproject.R;

public class MangerActivity extends AppCompatActivity {

    private Button genReport ;
    private Button addEmp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manger);
        genReport = findViewById(R.id.GenerateReport);
        addEmp = findViewById(R.id.AddEmployee);

    }

    public void handleAddEmployee(View view) {
        Intent intent = new Intent(this,AddEmployeeActivity.class);
        startActivity(intent);
    }

    public void handleGenerateReport(View view) {
        Intent intent = new Intent(this,GenerateReportActivity.class);
        startActivity(intent);

    }
}