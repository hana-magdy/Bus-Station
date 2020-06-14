

import java.util.ArrayList;

public abstract class Vehicle {
    ArrayList<Passenger> passengers=new ArrayList<>();
    private int seats;

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    private int ID;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getID() {
        return ID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    private String vehicleType;
    Trip trip;
    
}
