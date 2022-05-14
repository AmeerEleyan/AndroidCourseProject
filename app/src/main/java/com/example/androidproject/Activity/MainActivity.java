package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.Adaptor.CategoryAdaptor;
import com.example.androidproject.Adaptor.PoplurarAdaptor;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.Domain.FoodDomain;
import com.example.androidproject.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //test
    private RecyclerView.Adapter adapter , adapter2;
    private RecyclerView recyclerViewCategoryList ,recyclerViewPopularList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerViewCategoryList();
    }

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recylerView);
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

    private void recyclerViewPopularList() {

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        // open Poplurar View // 2'n RecyclerView in Video
        //        recyclerViewCategoryList=findViewById(R.id.recylerView2);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","Pizza1","Slice ,cheese , freash oregno",9.72));
        foodList.add(new FoodDomain("Cheese Burger","Burger","Burger ,Cheese , tomato",8.22));
        foodList.add(new FoodDomain("Vegetable Pizza","Pizza2","Vegetable ,cheese , tomato",10.72));
        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);


    }

}