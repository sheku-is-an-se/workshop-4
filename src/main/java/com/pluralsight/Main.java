package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String INVENTORY_FILE_PATH = "src/main/resources/inventory.csv";
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        userInterface.display();
    }
}