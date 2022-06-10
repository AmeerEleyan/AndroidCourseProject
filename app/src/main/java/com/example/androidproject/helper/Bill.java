package com.example.androidproject.helper;

public class Bill {
    private int customerId;
    private int billValue;

    public Bill() {
    }

    public Bill(int customerId, int billValue) {
        this.customerId = customerId;
        this.billValue = billValue;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBillValue() {
        return billValue;
    }

    public void setBillValue(int billValue) {
        this.billValue = billValue;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", billValue=" + billValue +
                '}';
    }
}

