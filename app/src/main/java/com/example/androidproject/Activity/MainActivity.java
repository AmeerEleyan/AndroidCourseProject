package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androidproject.Adaptor.CategoryAdaptor;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter , adapter2;
    private RecyclerView recyclerViewCategoryList ,recyclerViewPopularList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerViewCategoryList();
        bottomNavigation();
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

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.rv_category_items);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categories = new ArrayList<>();
        categories.add(new CategoryDomain("Pizza","cat_1"));
        categories.add(new CategoryDomain("Burger","cat_2"));
        categories.add(new CategoryDomain("Hotdog","cat_3"));
        categories.add(new CategoryDomain("Drink","cat_4"));
        categories.add(new CategoryDomain("Donut","cat_5"));
        adapter = new CategoryAdaptor(categories);
        recyclerViewCategoryList.setAdapter(adapter);

    }

}