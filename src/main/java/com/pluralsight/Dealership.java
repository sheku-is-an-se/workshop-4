package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();


    }


    public List<Vehicle> getVehiclesByPrice (int min, int max) {
        List<Vehicle> vehicleByPrice = new ArrayList<>();
    for (Vehicle v: inventory){
        if(v.getPrice() >= min && v.getPrice() <= max){
            vehicleByPrice.add(v);
        }
    }
    return vehicleByPrice;
    }


    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }
//
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicleByYear = new ArrayList<>();
        for (Vehicle v: inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                vehicleByYear.add(v);
            }
        }
        return vehicleByYear;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicleByColor = new ArrayList<>();
        for (Vehicle v: inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                vehicleByColor.add(v);
            }
        }
        return vehicleByColor;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehicleByMileage = new ArrayList<>();
        for (Vehicle v: inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                vehicleByMileage.add(v);
            }
        }
        return vehicleByMileage;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicleByType = new ArrayList<>();
        for (Vehicle v: inventory){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicleByType.add(v);
            }
        }
        return vehicleByType;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(int message) {
        Vehicle removedVehicle = null;
        for (Vehicle v : inventory) {
            if (v.getVin() == message) {
                removedVehicle = v;
            }
        }
        inventory.remove(removedVehicle);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
