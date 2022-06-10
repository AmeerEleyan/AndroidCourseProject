package com.example.androidproject.helper;

import android.content.Context;
import android.widget.Toast;

import com.example.androidproject.Domain.Meal;
import com.example.androidproject.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCart {
    private final Context context;
    private final TinyDB tinyDB;
    public ManagementCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }
    public void insertFood (Meal item){
        ArrayList<Meal> listFood = getListCart();
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

    public ArrayList<Meal> getListCart() {
        return tinyDB.getListObject("CartList");
    }


    public void plusNumberFood(ArrayList<Meal> listFood, int position, ChangeNumberItemListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<Meal> listfood, int position, ChangeNumberItemListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<Meal> listfood = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood.size(); i++) {
            fee = fee + (listfood.get(i).getSellingPrice() * listfood.get(i).getNumberInCart());
        }
        return fee;
    }



}
