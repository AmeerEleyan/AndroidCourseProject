package com.example.androidproject.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.DatabaseUtility.UserSession;
import com.example.androidproject.R;
import com.example.androidproject.helper.BillDetails;

import java.util.ArrayList;


// @Author :Abdallah
// 12-6-2022
public class ReportAdaptor extends RecyclerView.Adapter<ReportAdaptor.ViewHolder>{


    private final ArrayList<BillDetails> billDetailsList;

    public ReportAdaptor(ArrayList<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BillDetails billDetail = billDetailsList.get(position);

        holder.title.setText(billDetail.getMalaName());
        holder.counter.setText(billDetail.getQuantity());

        // Cast Price(Double) To String and put it in the text
        holder.profit.setText( billDetail.getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return billDetailsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

    TextView title , counter , profit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            counter=itemView.findViewById(R.id.numberItemTxt);
            profit=itemView.findViewById(R.id.profitTxt);

        }
    }


}
