package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.Adaptor.CategoryAdaptor;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategoryList;
    private ArrayList<CategoryDomain> categoryDomainArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.categoryDomainArrayList = new ArrayList<>();
        this.recyclerViewCategoryList = findViewById(R.id.rv_category_items);
        this.recyclerViewCategoryList.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        this.loadCategories();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn1);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartListActivity.class)));
        homeBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity.class)));

        // Change Only
   /*     homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });*/

    }

//    private void recyclerViewCategoryList() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewCategoryList = findViewById(R.id.rv_category_items);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        adapter = new CategoryAdaptor(categories);
//        recyclerViewCategoryList.setAdapter(adapter);
//
//    }

    private void loadCategories() {

        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/get_categories.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject obj = array.getJSONObject(i);

                                int id = Integer.parseInt(obj.getString("category_id"));
                                String category_name = obj.getString("category_name");
                                String category_image_path = obj.getString("category_image_path");
                                CategoryDomain categoryDomain = new CategoryDomain(id, category_name, category_image_path);
                                categoryDomainArrayList.add(categoryDomain);
                            }
                        } catch (Exception e) {

                        }

                        CategoryAdaptor adapter = new CategoryAdaptor(MainActivity.this, categoryDomainArrayList);
                        recyclerViewCategoryList.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }

}