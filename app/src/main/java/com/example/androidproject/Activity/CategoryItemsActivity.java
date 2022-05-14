package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.Adaptor.PopularAdaptor;
import com.example.androidproject.Domain.FoodDomain;
import com.example.androidproject.R;

import java.util.ArrayList;

public class CategoryItemsActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerViewPopularList=findViewById(R.id.rv_category_items);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","Pizza1","Slice ,cheese , freash oregno",9.72));
        foodList.add(new FoodDomain("Cheese Burger","Burger","Burger ,Cheese , tomato",8.22));
        foodList.add(new FoodDomain("Vegetable Pizza","Pizza2","Vegetable ,cheese , tomato",10.72));
        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}