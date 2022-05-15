package com.example.androidproject.helper;

import android.content.Context;

import com.example.androidproject.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private  TinyDB tinyDB;
    public ManagmentCart (Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }
    private void insertFood (FoodDomain item){
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




    }

    private ArrayList<FoodDomain> getListCart() {

        return null;

    }













}
