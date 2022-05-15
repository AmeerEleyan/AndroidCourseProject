package com.example.androidproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidproject.Domain.FoodDomain;
import com.example.androidproject.R;

public class showDetailActivity extends AppCompatActivity {
    private TextView addToChartBtn;
    private TextView titletxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    int numberOrder = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        intView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("Object");
        int drawableResouceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResouceId)
                .into(picFood);
        titletxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
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


    }

    private void intView() {
        addToChartBtn = findViewById(R.id.addToChartBtn);
        titletxt = findViewById(R.id.titletxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusbtn);
        minusBtn = findViewById(R.id.minusbtn);
        picFood = findViewById(R.id.picFood);


    }
}