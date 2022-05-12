package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // recyclerViewCategoryList();
    }

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recylerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);



        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Pizza","cat_1"));
        categories.add(new Category("Burger","cat_2"));
        categories.add(new Category("Hotdog","cat_3"));
        categories.add(new Category("Drink","cat_4"));
        categories.add(new Category("Donut","cat_5"));
        adapter = new CategoryAdaptor(categories);
        recyclerViewCategoryList.setAdapter(adapter);

    }

}