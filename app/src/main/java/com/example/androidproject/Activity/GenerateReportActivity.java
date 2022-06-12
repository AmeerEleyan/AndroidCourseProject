package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidproject.Adaptor.ReportAdaptor;
import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.R;
import com.example.androidproject.helper.BillDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GenerateReportActivity extends AppCompatActivity {

    private RecyclerView recyclerViewGenerateReport;
    private ArrayList<BillDetails> billDetailsArrayList;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        this.billDetailsArrayList = new ArrayList<>();
        this.recyclerViewGenerateReport = findViewById(R.id.GenerateReportView);
        this.recyclerViewGenerateReport.setLayoutManager(new LinearLayoutManager(GenerateReportActivity.this, LinearLayoutManager.HORIZONTAL, false));
        generateReport();
        queue = Volley.newRequestQueue(this);
    }

    private void generateReport() {

        String url = "http://" + UserSession.IP_ADDRESS + "/MobileProject/generate_reports.php";

        //
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            String male_name = obj.getString("male_name");
                            double male_price = Double.parseDouble(obj.getString("profit"));
                            int male_quantity = Integer.parseInt(obj.getString("sum_of_quantity"));
                            BillDetails billDetails = new BillDetails(male_name, male_price, male_quantity);
                            billDetailsArrayList.add(billDetails);
                        }catch(JSONException exception){
                            Toast.makeText(GenerateReportActivity.this, exception.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                    ReportAdaptor adapter = new ReportAdaptor(billDetailsArrayList);
                    recyclerViewGenerateReport.setAdapter(adapter);
                }, error -> Toast.makeText(GenerateReportActivity.this, error.toString(), Toast.LENGTH_LONG).show());

        queue.add(request);
        //

    }

}