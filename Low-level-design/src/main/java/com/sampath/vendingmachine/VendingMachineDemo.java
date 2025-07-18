package com.sampath.vendingmachine;

public class VendingMachineDemo {
    public static void main(String[] args)
    {
        VendingMachine machine = VendingMachine.getInstance();
        Product p1= new Product("1","TV","Entertainment",3.0);
        machine.getInventory().addItem(p1,20);
        machine.selectProduct(p1);
        Coin coin = new Coin(1);
        machine.insertCoin(coin);
        machine.insertCoin(coin);
        Product dispensedProd = machine.dispenseProduct();
        System.out.println(machine.getTotalBalance() + " | "+dispensedProd.getName());
        machine.insertCoin(coin);
        dispensedProd = machine.dispenseProduct();
        System.out.println(dispensedProd.getName());
        double balance = machine.returnChange();
        System.out.println(balance);


    }
}
