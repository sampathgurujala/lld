package com.sampath.vendingmachine.states;

import com.sampath.vendingmachine.Coin;
import com.sampath.vendingmachine.Product;
import com.sampath.vendingmachine.State;
import com.sampath.vendingmachine.VendingMachine;

public class ReturnChangeState extends State {
    public ReturnChangeState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public boolean addProduct(Product product, int quantity) {
        System.out.println("can't add the product now. please take the balance amount");
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
        System.out.println("Product is already dispensed");
        return new Product("XXXX","XXXX","XXXX",-1);
    }

    @Override
    public double returnChange() {
        double balanceAmnt = 0;
       if(machine.getTotalBalance()>0){
           balanceAmnt = machine.getTotalBalance();
           machine.setTotalBalance(0);
       }
        machine.setCurrState(new IdleState(machine));
        return  balanceAmnt;
    }
}
