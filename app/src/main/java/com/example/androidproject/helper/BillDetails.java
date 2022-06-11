package com.example.androidproject.helper;

public class BillDetails {
    private String malaName;
    private double price;
    private int quantity;

    public BillDetails(String malaName, double price, int quantity) {
        this.malaName = malaName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMalaName() {
        return malaName;
    }

    public void setMalaName(String malaName) {
        this.malaName = malaName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetails{" +
                "malaName='" + malaName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
