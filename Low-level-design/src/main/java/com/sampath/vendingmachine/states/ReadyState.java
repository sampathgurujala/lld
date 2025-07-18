package com.sampath.vendingmachine.states;

import com.sampath.vendingmachine.Coin;
import com.sampath.vendingmachine.Product;
import com.sampath.vendingmachine.State;
import com.sampath.vendingmachine.VendingMachine;

public class ReadyState extends State {

    public ReadyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public boolean addProduct(Product product, int quantity) {
        System.out.println("Can't add products now..");
        return false;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("You have already selected Product");
    }

    @Override
    public void insertCoin(Coin coin) {
            machine.setTotalBalance(machine.getTotalBalance()+coin.getValue());
            if(machine.getTotalBalance()>=machine.getSelectedProduct().getPrice())
                machine.setCurrState(new DispenseState(machine));
            return;
    }

    @Override
    public Product dispenseProduct() {
        System.out.println("Please insert coin");
        return new Product("XXXX","XXXX","XXXX",-1);
    }

    @Override
    public double returnChange() {
        System.out.println("Sorry, please insert coin to continue");
        return 0;
    }
}
