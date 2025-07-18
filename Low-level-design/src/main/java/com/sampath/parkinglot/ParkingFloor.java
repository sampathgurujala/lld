package com.sampath.parkinglot;

import com.sampath.parkinglot.parkingspot.ParkingSpot;
import com.sampath.parkinglot.vehicle.Vehicle;
import com.sampath.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int flrNo;
    private final List<ParkingSpot> parkingSpotList;

    public  ParkingFloor (int flrNo)
    {
        this.flrNo = flrNo;
        this.parkingSpotList = new ArrayList<>();
    }
    public void  addSpot(ParkingSpot spot)
    {
        parkingSpotList.add(spot);
    }
    public Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle)
    {
        parkingSpotList.stream().filter( spot -> (spot.isSpotAvailable() && spot.canFitVehicle(vehicle))).findFirst();

    }
}
