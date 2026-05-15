package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.Main.INVENTORY_FILE_PATH;

public class UserInterface {
    DealershipFileManager dealershipFileManager = new DealershipFileManager();
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {}

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.loadDealership(INVENTORY_FILE_PATH);
        }
    public void display(){
        init();
        String menu = """
        ╔══════════════════════════════════════════════╗
        ║            CAR DEALERSHIP CENTER             ║
        ╠══════════════════════════════════════════════╣
        ║       Search, add, and remove vehicles       ║
        ╚══════════════════════════════════════════════╝
        
                        DEALERSHIP MENU
        ------------------------------------------------
        [1] Find vehicles by price range
        [2] Find vehicles by make/model
        [3] Find vehicles by year range
        [4] Find vehicles by color
        [5] Find vehicles by mileage range
        [6] Find vehicles by type
        [7] List ALL vehicles
        [8] Add a vehicle
        [9] Remove a vehicle
        [99] Quit
        ------------------------------------------------
        Enter your choice:\s""";

        boolean running = true;

        do {
            System.out.print(menu);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    running = false;
                    break;
                default:
                    System.err.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);
    }
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("----------------------------------------");
            System.out.println("VIN: " + vehicle.getVin());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Type: " + vehicle.getVehicleType());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Odometer: " + vehicle.getOdometer());
            System.out.println("Price: $" + vehicle.getPrice());
        }
        PromptParser.pause();
    }

    public void processGetByPriceRequest(){
        int min = PromptParser.promptForInteger("Enter price minimum");
        int max = PromptParser.promptForInteger("Enter price maximum");
        List<Vehicle> vehiclesPrice = this.dealership.getVehiclesByPrice(min,max);
        displayVehicles(vehiclesPrice);

    }

    public void processGetByMakeModelRequest(){
        String make = PromptParser.promptForString("What make model would you like to search by?: ");
        //List<Vehicle> vehiclesPrice = this.dealership.getVehiclesByMakeModel(min,max);
        //displayVehicles(vehiclesPrice);

    }
    public void processGetByYearRequest(){
        int min = PromptParser.promptForInteger("Enter year minimum");
        int max = PromptParser.promptForInteger("Enter year maximum");
        List<Vehicle> vehiclesByYear = this.dealership.getVehiclesByYear(min, max);
        displayVehicles(vehiclesByYear);

    }

    public void processGetByColorRequest(){
        String color = PromptParser.promptForString("Enter the color: ");
        List<Vehicle> vehiclesColor = this.dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesColor);

    }

    public void processGetByMileageRequest(){
        int min = PromptParser.promptForInteger("Enter mileage minimum: ");
        int max = PromptParser.promptForInteger("Enter mileage maximum: ");
        List<Vehicle> vehiclesByMileage = this.dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehiclesByMileage);

    }

    public void processGetByVehicleTypeRequest(){
        String type = PromptParser.promptForString("Enter the vehicleType: ");
        List<Vehicle> vehiclesType = this.dealership.getVehiclesByType(type);
        displayVehicles(vehiclesType);
    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);

    }

    public void processAddVehicleRequest(){

            int vin = PromptParser.promptForInteger("Enter the vin: ");
            int year = PromptParser.promptForInteger("Enter the year: ");
            String make = PromptParser.promptForString("Enter the make: ");
            String model = PromptParser.promptForString("Enter the model: ");
            String vehicleType = PromptParser.promptForString("Enter the vehicle type: ");
            String color = PromptParser.promptForString("Enter the color: ");
            int odometer = PromptParser.promptForInteger("Enter the mileage: ");
            double price = PromptParser.promptForAmount("Enter the price: ");

            Vehicle newVehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
            dealership.addVehicle(newVehicle);

            dealershipFileManager.saveDealership(this.dealership,INVENTORY_FILE_PATH);

    }

    public void processRemoveVehicleRequest(){
        int vin = PromptParser.promptForInteger("Enter the vin of the vehicle you'd like to remove: ");

        dealership.removeVehicle(vin);
        dealershipFileManager.saveDealership(this.dealership,INVENTORY_FILE_PATH);


    }
}
