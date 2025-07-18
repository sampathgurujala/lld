package com.sampath.parkinglot.parkingspot;

import com.sampath.parkinglot.vehicle.Vehicle;
import com.sampath.parkinglot.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot
{
    public LargeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return (VehicleType.TRUCK==vehicle.getType());
    }
}
