package com.sampath.parkinglot.parkingspot;

import com.sampath.parkinglot.vehicle.Vehicle;
import com.sampath.parkinglot.vehicle.VehicleType;

public class CompactSpot extends ParkingSpot{

    public CompactSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return (VehicleType.CAR==vehicle.getType());
    }
}
