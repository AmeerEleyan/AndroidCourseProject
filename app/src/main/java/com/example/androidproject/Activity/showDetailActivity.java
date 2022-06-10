package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidproject.Domain.Meal;
import com.example.androidproject.R;
import com.example.androidproject.helper.ManagementCart;

public class showDetailActivity extends AppCompatActivity {
    private TextView addToChartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private Meal meal;
    int numberOrder = 1 ;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart = new ManagementCart(this);
        intView();
        getBundle();
    }

    private void getBundle() {
        meal = (Meal) getIntent().getSerializableExtra("object");


        // Error Here ............................
        int drawableResourceId = this.getResources().getIdentifier(meal.getPic(), "drawable", this.getPackageName());


        Glide.with(this).load(drawableResourceId).into(picFood);

        titleTxt.setText(meal.getTitle());
        feeTxt.setText("$"+ meal.getSellingPrice());
        descriptionTxt.setText(meal.getDescription());
        numberOrderTxt.setText(numberOrder);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1)
                    numberOrder = numberOrder -1 ;
            numberOrderTxt.setText(String.valueOf(numberOrder));
            }

        });
        addToChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meal.setNumberInCart(numberOrder);
                managementCart.insertFood(meal);
            }
        });


    }

    private void  intView() {
        addToChartBtn = findViewById(R.id.addToChartBtn);
        titleTxt = findViewById(R.id.titleText);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusbtn);
        minusBtn = findViewById(R.id.minusbtn);
        picFood = findViewById(R.id.picFood);

    }
}