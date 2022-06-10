package com.example.androidproject.helper;

public class BillDetails {
    private int price;
    private int quantity;


    public BillDetails(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public BillDetails() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
