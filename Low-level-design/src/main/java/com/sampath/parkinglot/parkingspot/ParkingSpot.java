package com.sampath.parkinglot.parkingspot;

import com.sampath.parkinglot.vehicle.Vehicle;
import com.sampath.parkinglot.vehicle.VehicleType;

public abstract class  ParkingSpot {
    private final String spotId;
    private Vehicle vehicle;
    private boolean isSpotAvailable;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isSpotAvailable = true;
    }
    public void assignVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        isSpotAvailable = false;
    }
    public  void removeVehicle()
    {
        this.vehicle = null;
        isSpotAvailable = true;
    }
    public boolean isSpotAvailable() {
        return isSpotAvailable;
    }
    public abstract boolean canFitVehicle(Vehicle vehicle);
}
