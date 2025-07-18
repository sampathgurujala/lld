package com.sampath.restaurantmanagementsystem.payment;

public class CreditCard implements Payment{

    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}
