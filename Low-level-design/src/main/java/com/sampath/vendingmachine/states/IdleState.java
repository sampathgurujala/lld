package com.sampath.vendingmachine.states;

import com.sampath.vendingmachine.Coin;
import com.sampath.vendingmachine.Product;
import com.sampath.vendingmachine.State;
import com.sampath.vendingmachine.VendingMachine;

public class IdleState extends State {

    public IdleState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public boolean addProduct(Product product,int quantity)
    {
        machine.getInventory().addItem(product,quantity);
        return  true;
    }
    @Override
    public void selectProduct(Product product)
    {

        boolean isAvailable = machine.getInventory().isProductAvailable(product);
        if(isAvailable)
        {
            machine.setSelectedProduct(product);
            machine.setCurrState(new ReadyState(super.machine));
        }
        else
            System.out.println("Select again");
        return;

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please Select a Product First! ");
    }

    @Override
    public  Product dispenseProduct()
    {
        System.out.println("Please Select a Product First! ");
        return  new Product("XXXX","XXXX","XXXX",-1.0);
    }
    @Override
    public double returnChange()
    {
        System.out.println("Please Select a Product First! ");
        return -1.0;
    }
}

