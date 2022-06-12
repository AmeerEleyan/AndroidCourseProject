package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.Adaptor.CategoryAdaptor;
import com.example.androidproject.Adaptor.ReportAdaptor;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.R;
import com.example.androidproject.helper.BillDetails;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GenerateReportActivity extends AppCompatActivity {

    private RecyclerView recyclerViewGenerateReport;
    private ArrayList<BillDetails> billDetailsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        this.billDetailsArrayList = new ArrayList<>();
        this.recyclerViewGenerateReport = findViewById(R.id.rv_category_items);
        this.recyclerViewGenerateReport.setLayoutManager(new LinearLayoutManager(GenerateReportActivity.this, LinearLayoutManager.HORIZONTAL, false));
        generateReport();
    }
    private void generateReport() {

        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/get_generate_report.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject obj = array.getJSONObject(i);

                                String male_name = obj.getString("male_name");
                                double male_price =Double.parseDouble( obj.getString("male_price"));
                                int male_quantity =Integer.parseInt( obj.getString("male_quantity"));
                                BillDetails billDetails = new BillDetails(male_name,male_price, male_quantity);
                                billDetailsArrayList.add(billDetails);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        ReportAdaptor adapter = new ReportAdaptor( billDetailsArrayList);
                        recyclerViewGenerateReport.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GenerateReportActivity.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(GenerateReportActivity.this).add(stringRequest);
    }

}