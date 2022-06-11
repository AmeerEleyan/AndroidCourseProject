package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddEmployeeActivity extends AppCompatActivity {


    private EditText userName, pass, confirmPass, employeeName, employeeSalary;
    private String employeeType="";
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private RequestQueue queue;
    private JSONObject responseJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        this.radioGroup = findViewById(R.id.radioGroupAddEmployee);
        this.userName = findViewById(R.id.EmployeeUserNameEditText);
        this.pass = findViewById(R.id.EmployeePasswordEditText);
        this.confirmPass = findViewById(R.id.EmployeeConfirmPasswordEditText);
        this.employeeName = findViewById(R.id.EmployeeNameEditText);
        this.employeeSalary = findViewById(R.id.EmployeeSalaryEditText);
        this.queue = Volley.newRequestQueue(this);
    }

    public void handleAddEmployeeEmployeePage(View view) {

        if (this.userName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the user name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.pass.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.confirmPass.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the confirm password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.employeeName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the employee name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.employeeSalary.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the employee salary", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!this.pass.getText().toString().equals(this.confirmPass.getText().toString())) {
            Toast.makeText(this, "Not match password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(this.radioButton.getText().toString().trim().equals("Chef"))
            this.employeeType="2";
        else
            this.employeeType="3";

        this.handleAddEmployeeEmployeePage(this.userName.getText().toString().trim(), this.pass.getText().toString().trim(), this.employeeName.getText().toString().trim(), this.employeeSalary.getText().toString().trim(), this.employeeType);

    }

    private void handleAddEmployeeEmployeePage(String userName, String pass, String employeeName, String employeeSalary, String employeeType) {

        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/new_employee_account.php";
        RequestQueue queue = Volley.newRequestQueue(AddEmployeeActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (!response.isEmpty()) {
                        responseJsonObject = new JSONObject(response);
                        if (responseJsonObject.has("insert") && !responseJsonObject.isNull("insert")) {
                            JSONObject responseJsonObject2 = responseJsonObject.getJSONObject("insert");
                            if (responseJsonObject2.getString("error").equals("false")) {
                                Toast.makeText(AddEmployeeActivity.this, "new account was created successfully", Toast.LENGTH_SHORT).show();
                                goToMangerActivity();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(AddEmployeeActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("user_name", userName);
                params.put("pass_word", pass);
                params.put("employee_name", employeeName);
                params.put("employee_salary", employeeSalary);
                params.put("employee_type",employeeType);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }


    public void onRadioButtonClicked(View view) {

        int radioID = radioGroup.getCheckedRadioButtonId();
        this.radioButton = findViewById(radioID);

    }

    private void goToMangerActivity() {
        startActivity(new Intent(this, MangerActivity.class));
    }
}