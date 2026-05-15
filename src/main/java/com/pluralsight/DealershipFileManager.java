package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

import static com.pluralsight.Main.INVENTORY_FILE_PATH;

public class DealershipFileManager {

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
                    dealership = new Dealership(name, address, phone);
                }
                if (parts.length == 8) {
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

            dealership.getAllVehicles().sort(Comparator.comparing(Vehicle::getYear));


        } catch (FileNotFoundException fne) {
            System.err.println("File not found: " + fileName);
        } catch (IOException ex) {
            System.out.println("Error loading transactions file: " + ex);
            throw new RuntimeException(ex);
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership, String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            bufferedWriter.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bufferedWriter.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving dealership file: " + e.getMessage());
        }
    }

    }

