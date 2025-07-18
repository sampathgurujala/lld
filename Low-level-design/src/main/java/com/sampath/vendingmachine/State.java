package com.sampath.vendingmachine;

public abstract class State {

    protected VendingMachine machine;
     public State(VendingMachine machine)
     {
         this.machine = machine;
     }
     public abstract boolean addProduct(Product product,int quantity);
     public abstract void selectProduct(Product product);
    public abstract void insertCoin(Coin coin);
     public abstract Product dispenseProduct();
     public abstract double returnChange();

}
