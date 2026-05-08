package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DealershipFileManager {

    String INVENTORY_FILE_PATH = "src/main/java/resources/inventory.csv";

    public Dealership loadDealership(String fileName) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Dealership dealership = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            //Read the first line
            String line = bufferedReader.readLine();

            String phone = null;
            String address = null;
            String name = null;
            while (line != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        name = parts[0];
                        address = parts[1];
                        phone = parts[2];
                        dealership = new Dealership(name,address,phone);
                    }if (parts.length == 8) {
                        int vin = Integer.parseInt(parts[0]);
                        int year = Integer.parseInt(parts[1]);
                        String make = parts[2];
                        String model = parts[3];
                        String vehicleType = parts[4];
                        String color = parts[5];
                        int odemeter = Integer.parseInt(parts[6]);
                        double price = Double.parseDouble(parts[7]);
                        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odemeter, price);
                        dealership.addVehicle(vehicle);

                    }
                    line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException fne) {
            System.err.println("File not found: " + fileName);
        } catch (IOException ex) {
            System.out.println("Error loading transactions file: " + ex);
            throw new RuntimeException(ex);
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {

    }
}
