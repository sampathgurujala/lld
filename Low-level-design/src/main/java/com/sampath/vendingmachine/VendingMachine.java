package com.sampath.vendingmachine;

import com.sampath.vendingmachine.states.IdleState;

public class VendingMachine {
    private static VendingMachine INSTANCE = null;
    private State currState;
    private Inventory inventory;
    private double totalBalance;
    private Product selectedProduct;


    private VendingMachine()
    {
        this.inventory = new Inventory();
        inventory = new Inventory();
        this.totalBalance = 0;
        this.selectedProduct= null;
    }

    public static synchronized VendingMachine getInstance()
    {
        if(INSTANCE==null)
        {
            INSTANCE = new VendingMachine();
            INSTANCE.currState = new IdleState(INSTANCE);
        }
        return  INSTANCE;
    }
    public State getCurrState()
    {
        return  this.currState;
    }
    public void setCurrState(State state)
    {
        this.currState = state;
        return;
    }
    public boolean addProduct(Product product, int quantity)
    {
     return  this.currState.addProduct(product,quantity);

    }
    public void selectProduct(Product product)
    {
      this.currState.selectProduct(product);
      return;
    }
    public void insertCoin(Coin coin)
    {
        this.currState.insertCoin(coin);
    }
    public Product dispenseProduct()
    {
        return this.currState.dispenseProduct();
    }
    public double returnChange()
    {
       return  this.currState.returnChange();
    }
//Getters and Setters
    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
