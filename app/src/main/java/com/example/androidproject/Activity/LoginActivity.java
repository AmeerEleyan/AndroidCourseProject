package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Amir Eleyan
 * ID: 1191076
 * Date: 30/4/2022      1:30 AM
 * Android Course
 */
public class LoginActivity extends AppCompatActivity {

    private EditText uname, passwd;
    private JSONObject responseJsonObject;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberMeCB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.uname = findViewById(R.id.uname);
        this.passwd = findViewById(R.id.password_sign_up);
        this.rememberMeCB = findViewById(R.id.remember_me);

        setupSharedPrefs();
        checkPrefs();

        RequestQueue queue = Volley.newRequestQueue(this);
    }

    private void checkPrefs() {
        boolean flag = sharedPreferences.getBoolean("FLAG",false);
        if(flag){
            String name  = sharedPreferences.getString("NAME","");
            String password = sharedPreferences.getString("PASSWORD","");
            this.uname.setText(name);
            this.passwd.setText(password);
            this.rememberMeCB.setChecked(true);

        }
    }

    private void setupSharedPrefs() {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.editor = sharedPreferences.edit();
    }

    public void handleLogin(View view) {


        String name = this.uname.getText().toString();
        String pass = this.passwd.getText().toString() ;
        if( rememberMeCB.isChecked() ){
            this.editor.putString("NAME",name.trim());
            this.editor.putString("PASSWORD",pass.trim());
            this.editor.putBoolean("FLAG",true);
            this.editor.commit();
        }
        this.login(name.trim(), pass.trim());

    }

    private void login(String user_name, String pass_word) {
        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/user_type.php";
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST,
                url,
                new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (!response.isEmpty()) {
                        responseJsonObject = new JSONObject(response);
                        if (responseJsonObject.has("user") && !responseJsonObject.isNull("user")) {
                            JSONObject responseJsonObject2 = responseJsonObject.getJSONObject("user");
                            UserSession.USER_ID_IN_SESSION = Integer.parseInt(responseJsonObject2.getString("id"));
                            UserSession.USER_TYPE = Integer.parseInt(responseJsonObject2.getString("login_type"));
                            if (UserSession.USER_TYPE == 1) {
                                goToMainActivity();
                            }
                            else if(UserSession.USER_TYPE==2)
                            {
                                goToMangerActivity();
                            }
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(LoginActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
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
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("user_name", user_name);
                params.put("pass_word", pass_word);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void goToMangerActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void handleSignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

}