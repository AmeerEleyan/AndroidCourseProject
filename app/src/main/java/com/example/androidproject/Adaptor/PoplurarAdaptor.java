package com.example.androidproject.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidproject.Domain.CategoryDomain;
import com.example.androidproject.Domain.FoodDomain;
import com.example.androidproject.R;

import java.util.ArrayList;

public class PoplurarAdaptor extends RecyclerView.Adapter<PoplurarAdaptor.ViewHolder> {


    ArrayList<FoodDomain> categoryFood;

    public PoplurarAdaptor(ArrayList<FoodDomain> categories) {
        this.categoryFood = categories;
    }

    @NonNull
    @Override
    public PoplurarAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);

        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull PoplurarAdaptor.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryFood.get(position).getTitle());
        String picUrl = " ";
        switch (position) {

            case 0: {
                picUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background1));
                break;
            }

            case 1: {
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background2));
                break;
            }

            case 2: {
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background3));
                break;
            }

            case 3: {
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background4));
                break;
            }


            case 4: {
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background5));
                break;
            }
        }

        int drawableResourceID = holder.itemView.getContext().getResources().getIdentifier
                (picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceID).into(holder.categoryPic);

    }

    @Override
    public int getItemCount() {
        return categoryFood.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryPizzaName);
            categoryPic = itemView.findViewById(R.id.categoryPizzaPic);
            mainLayout = itemView.findViewById(R.id.categoryLayout);
        }
    }
}