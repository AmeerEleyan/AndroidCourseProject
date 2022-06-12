package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.Adaptor.CategoryAdaptor;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.R;
import com.example.androidproject.helper.Bill;
import com.example.androidproject.helper.BillDetails;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityChef extends AppCompatActivity {
    private RecyclerView recyclerViewChefOrderList;
    private ArrayList<Bill> billOrderArrayList;
    private Bill bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheif);
        this.recyclerViewChefOrderList = findViewById(R.id.orderListRecyclerView);
        this.recyclerViewChefOrderList.setLayoutManager(new LinearLayoutManager(ActivityChef.this, LinearLayoutManager.VERTICAL, false));
        this.bill= new Bill();
        this.billOrderArrayList= new ArrayList<>();
        loadOrderList();
    }


    private void loadOrderList() {

        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/get_order.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject obj = array.getJSONObject(i);

                                int id = Integer.parseInt(obj.getString("bill_id"));

                                String meal_name = obj.getString("meal_name");

                                String quantity = obj.getString("quantity");
                               // CategoryDomain categoryDomain = new CategoryDomain(id, meal_name, category_image_path);
                               // categoryDomainArrayList.add(categoryDomain);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                     //   CategoryAdaptor adapter = new CategoryAdaptor(MainActivity.this, categoryDomainArrayList);
                      //  recyclerViewCategoryList.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityChef.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(ActivityChef.this).add(stringRequest);
    }
}