import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

      
        // UC2: Add Passenger Bogies to Train (ArrayList Operations)
        System.out.println("--- UC2: Adding Passenger Bogies ---");
        System.out.println();

        // Add bogies: Sleeper, AC Chair, First Class
        System.out.println("Adding passenger bogies...");
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Bogies added successfully.");
        System.out.println();

        // Print the list after insertion
        System.out.println("Current passenger bogies in train:");
        for (int i = 0; i < passengerBogies.size(); i++) {
            System.out.println((i + 1) + ". " + passengerBogies.get(i));
        }
        System.out.println("Total bogies: " + passengerBogies.size());
        System.out.println();

        // Remove one bogie (for example AC Chair)
        System.out.println("Removing AC Chair bogie...");
        passengerBogies.remove("AC Chair");
        System.out.println("AC Chair removed successfully.");
        System.out.println();

        // Print the list after removal
        System.out.println("Updated passenger bogies in train:");
        for (int i = 0; i < passengerBogies.size(); i++) {
            System.out.println((i + 1) + ". " + passengerBogies.get(i));
        }
        System.out.println("Total bogies: " + passengerBogies.size());
        System.out.println();

        // Use contains() to check if Sleeper exists
        System.out.println("Checking if Sleeper bogie exists...");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("✓ Sleeper bogie exists in the consist.");
        } else {
            System.out.println("✗ Sleeper bogie does not exist in the consist.");
        }
        System.out.println();

        // Print final list state
        System.out.println("Final Train Consist Summary:");
        System.out.println("Total passenger bogies: " + passengerBogies.size());
        System.out.println("Composition: " + passengerBogies.toString());
        System.out.println();
        System.out.println("Program continues...");
    }
}
