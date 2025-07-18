package com.sampath.restaurantmanagementsystem;

public class Table {
    private int id;
    private int capacity;
    private boolean isAvailable;
    public Table(int id, int capacity)
    {
        this.capacity =capacity;
        this.id= id;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
    public void reserve()
    {
        this.isAvailable = false;
    }
    public void makeAvailable()
    {
        this.isAvailable = true;
    }

}
