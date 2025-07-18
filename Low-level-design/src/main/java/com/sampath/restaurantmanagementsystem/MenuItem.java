package com.sampath.restaurantmanagementsystem;

public class MenuItem {

    private String name;
    private String description;
    private double price;
    private  boolean isAvailable;

    public MenuItem(String name, String description, double price, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
