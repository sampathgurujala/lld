package com.sampath.parkinglot;

import com.sampath.parkinglot.parkingspot.ParkingSpot;
import com.sampath.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot INSTANCE;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;
        private ParkingLot( )
        {
            feeStrategy = new FeeStrategy();
        }
        public synchronized ParkingLot getInstance()
        {
            if(INSTANCE==null)
                INSTANCE = new ParkingLot();
            return INSTANCE;
        }
    public  synchronized void parkVehicle(Vehicle vehicle)
    {

        for(ParkingFloor floor: floors)
        {
            Optional<ParkingSpot> availableSpot = floor.getAvailableSpot(vehicle);
            if(availableSpot.isPresent())
            {
                ParkingSpot spot = availableSpot.get();
                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle.getLicensePlate(), spot,vehicle);
                activeTickets.put(vehicle.getLicensePlate(), ticket);
                break;
            }
        }
        return;
    }
    public synchronized double unparkVehicle(String licensePlate) throws Exception {
        Ticket ticket = activeTickets.remove(licensePlate);
        if(ticket == null)
            throw new Exception("Invalid License Plate!...");
        activeTickets.remove(ticket);
        ticket.getSpot().removeVehicle();
       return feeStrategy.generateBill(ticket);
    }
}
