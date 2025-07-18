package com.sampath.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String,Product> productMap;
    private Map<String,Integer> stockMap;
    public Inventory()
    {
        productMap = new HashMap<>();
        stockMap = new HashMap<>();
    }
    public int getQuantity(Product product)
    {
        if(stockMap.containsKey(product.getId()))
        {
            return stockMap.get(product.getId());
        }
        return -1;
    }
    public boolean reduceQuantity(Product product)
    {
        if(isProductAvailable(product))
        {
            stockMap.put(product.getId(), stockMap.get(product.getId())-1);
            return true;
        }
        return false;
    }
    public boolean addItem(Product product,int quantity)
    {
        if(quantity<0)
            return false;
        if(!productMap.containsKey(product.getId()))
        {
            productMap.put(product.getId(),product);
        }
        stockMap.put(product.getId(),stockMap.getOrDefault(product.getId(),0)+quantity);
        return true;
    }
    public boolean isProductAvailable(Product product)
    {
        if(productMap.containsKey(product.getId()) && stockMap.getOrDefault(product.getId(),0)>0)
        {
            return true;
        }
        return  false;
    }
}
