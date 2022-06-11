package com.example.androidproject.helper;

public class BillDetails {
    private double price;
    private int quantity;


    public BillDetails(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public BillDetails() {
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

    public BillDetails setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
