package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.androidproject.Adaptor.CartListAdaptor;
import com.example.androidproject.R;
import com.example.androidproject.helper.ManagementCart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewList;
    TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private ScrollView scrollView;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        this.managementCart = new ManagementCart(this);
        initView();
        initList();
        CalculateCart();
        bottomNavigation();

    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn2);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(view -> startActivity(new Intent(CartListActivity.this, CartListActivity.class)));
        homeBtn.setOnClickListener(view -> startActivity(new Intent(CartListActivity.this, MainActivity.class)));

    }

    private void initView() {
        recyclerViewList = findViewById(R.id.cartView);
        taxTxt = findViewById(R.id.taxTxt);
        totalFeeTxt = findViewById(R.id.totalFeelTxt);
        deliveryTxt = findViewById(R.id.deliveryServiceTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyText);
        scrollView = findViewById(R.id.scrollView3);

    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        CartListAdaptor adaptor = new CartListAdaptor(managementCart.getListCart(), this);
        recyclerViewList.setAdapter(adaptor);
        if (managementCart.isCartEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void CalculateCart() {
        double percentTax = 0.02;
        double delivery = 10;

        double tax = Math.round((managementCart.getTotalFee() * percentTax) * 100) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100.0;

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);
    }

}