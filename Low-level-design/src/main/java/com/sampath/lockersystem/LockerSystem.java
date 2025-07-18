package com.sampath.lockersystem;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LockerSystem {
    public static LockerSystem INSTANCE =null;
    List<Locker> lockerList;
    NotificationSender notificationSender;

    public LockerSystem() {
        this.notificationSender = new NotificationSender();
        this.lockerList = new CopyOnWriteArrayList<>();

    }
    public synchronized LockerSystem getInstance()
    {
        if(INSTANCE==null)
            INSTANCE = new LockerSystem();
        return INSTANCE;
    }
    public  void addLocker(Locker locker)
    {
        this.lockerList.add(locker);
    }
    public void addCustomers(List<Customer> customers)
    {
        for(Customer customer: customers) {
            this.notificationSender.add(customer);
        }
    }
    public void assignPackage(Package package)
    {
        for(Locker locker: lockerList)
        {
            if(locker.isEmpty() && locker.canFit(package))
            {
                locker.assign(package);
                sendNotification(package.getCustomerId());
                return;
            }
        }
    }
    public Package receivePackage(String packageId, Customer customer)
    {

    }


}
