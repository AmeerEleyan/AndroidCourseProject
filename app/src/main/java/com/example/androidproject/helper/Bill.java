package com.example.androidproject.helper;

import java.util.ArrayList;

public class Bill {
   private String billId;
   private ArrayList<BillDetails> billDetailsList;

    public Bill() {
    }

    public Bill(String billId, ArrayList<BillDetails> billDetailsList) {
        this.billId = billId;
        this.billDetailsList = billDetailsList;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public ArrayList<BillDetails> getBillDetailsList() {
        return billDetailsList;
    }

    public void setBillDetailsList(ArrayList<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", billDetailsList=" + billDetailsList +
                '}';
    }
}

