package com.example.androidproject.helper;

import android.content.Context;
import android.widget.Toast;

import com.example.androidproject.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private  TinyDB tinyDB;
    public ManagmentCart (Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }
    public void insertFood (FoodDomain item){
        ArrayList<FoodDomain> listFood = getListCart();
        boolean exitAlready = false;
        int n = 0 ;
        for (int i = 0 ; i < listFood.size() ; i++){
            if (listFood.get(i).getTitle().equalsIgnoreCase(item.getTitle())){
                exitAlready = true;
                n = i ;
                break;
            }
        }
        if (exitAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());

        }else {
            listFood.add(item);
        }
        tinyDB.putListObject("CardList",listFood);
        Toast.makeText(context, "Add To Your Cart", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<FoodDomain> getListCart() {

        return tinyDB.getListObject("CartList");

    }













}
