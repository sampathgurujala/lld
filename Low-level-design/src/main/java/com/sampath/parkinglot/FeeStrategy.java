package com.sampath.parkinglot;

import com.sampath.parkinglot.vehicle.VehicleType;

import java.util.Date;

public class FeeStrategy {

    public double generateBill(Ticket ticket)
    {
        long entryTime = ticket.getEntryTime();
        long exitTime = new Date().getTime();
        double hours = (exitTime- entryTime)/(double)(60*60*100);
        ticket.setExitTime(exitTime);
        if(ticket.getVehicle().getType() == VehicleType.BIKE)
        {
            return hours * 10.0;
        }
        else if(ticket.getVehicle().getType() == VehicleType.CAR)
        {
            return hours * 15.0;
        }
        else if(ticket.getVehicle().getType() == VehicleType.TRUCK)
        {
            return  hours * 20.0;
        }
        return hours * 5.0;
    }
}
