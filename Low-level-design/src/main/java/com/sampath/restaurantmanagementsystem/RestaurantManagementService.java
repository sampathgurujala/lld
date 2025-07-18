package com.sampath.restaurantmanagementsystem;

import com.sampath.restaurantmanagementsystem.payment.Payment;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RestaurantManagementService {
    public static RestaurantManagementService INSTANCE = null;
    private Map<String,MenuItem> menu;
    private Map<String,String > orders;
    private List<Staff> staffList;
    private Map<Integer,Table>  tables;
    private Map<Integer, Payment> payments;
    private List<Reservation> reservations;

    public RestaurantManagementService()
    {
        this.orders = new ConcurrentHashMap<>();
        this.reservations = new CopyOnWriteArrayList<>();
        this.tables = new ConcurrentHashMap<>();
        this.staffList = new CopyOnWriteArrayList<>();
        this.payments = new ConcurrentHashMap<>();
    }

    public synchronized  RestaurantManagementService getInstance() {
        if(INSTANCE ==null)
        {
            INSTANCE = new RestaurantManagementService();
        }
        return INSTANCE;
    }
    public  void addTable(int tableId, int capacity)
    {
        Table table = new Table(tableId,capacity);
        tables.put(tableId,table);
        return;
    }
    public void addMenuItem(String itemName, String description , boolean isAvailable, double price)
    {
        MenuItem menuItem = new MenuItem(itemName,description,price,isAvailable);
        menu.put(itemName, menuItem);
    }
    public void removeMenuItem(String itemName)
    {
        if(menu.containsKey(itemName) )
        {
            menu.remove(itemName);
        }
        return;
    }



}
