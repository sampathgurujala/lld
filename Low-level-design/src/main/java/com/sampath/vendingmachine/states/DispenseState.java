package com.sampath.vendingmachine.states;

import com.sampath.vendingmachine.Coin;
import com.sampath.vendingmachine.Product;
import com.sampath.vendingmachine.State;
import com.sampath.vendingmachine.VendingMachine;

public class DispenseState extends State {

    public DispenseState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public boolean addProduct(Product product, int quantity) {
        System.out.println("Can't add products now..");
        return false;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Can't select product now...");

    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("You have already inserted the amount. please take the balance amnnt..");
    }

    @Override
    public Product dispenseProduct() {

            machine.getInventory().reduceQuantity(machine.getSelectedProduct());
            machine.setTotalBalance(machine.getTotalBalance()-machine.getSelectedProduct().getPrice());
            Product toDispense =  machine.getSelectedProduct();
            machine.setSelectedProduct(null);
            machine.setCurrState(new ReturnChangeState(machine));
            return toDispense;
    }

    @Override
    public double returnChange() {
        System.out.println("Please take the product first");
        return -1.0;
    }
}
