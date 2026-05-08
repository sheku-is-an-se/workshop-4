package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {}

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.loadDealership("inventory.csv");
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
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }
    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);

    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }
}
