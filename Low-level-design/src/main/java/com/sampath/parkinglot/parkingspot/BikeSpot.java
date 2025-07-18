package com.sampath.parkinglot.parkingspot;

import com.sampath.parkinglot.vehicle.Vehicle;
import com.sampath.parkinglot.vehicle.VehicleType;

public class BikeSpot extends ParkingSpot{

    public BikeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        return (VehicleType.BIKE==vehicle.getType());
    }
}
