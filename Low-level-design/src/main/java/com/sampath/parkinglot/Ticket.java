package com.sampath.parkinglot;

import com.sampath.parkinglot.parkingspot.ParkingSpot;
import com.sampath.parkinglot.vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    private final String tickedId;
    private final Vehicle Vehicle;
    private final ParkingSpot spot;
    private final long entryTime;
    private long exitTime;

    public Ticket(String tickedId, ParkingSpot spot, com.sampath.parkinglot.vehicle.Vehicle vehicle) {
        this.tickedId = tickedId;
        this.spot = spot;
        this.entryTime = new Date().getTime();
        Vehicle = vehicle;
    }

    public String getTickedId() {
        return tickedId;
    }

    public Vehicle getVehicle() {
        return Vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
