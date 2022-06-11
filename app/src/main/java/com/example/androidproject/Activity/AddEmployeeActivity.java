package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.androidproject.R;

public class AddEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
    }

    public void handleAddEmployeeEmployeePage(View view) {
    }

    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_Chef:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_DeliveryEmployee:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}