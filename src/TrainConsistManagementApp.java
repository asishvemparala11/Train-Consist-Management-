import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // Initialize an empty List using ArrayList to store bogies
        List<String> bogies = new ArrayList<>();

        // Display the initial bogie count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial bogie count: " + bogies.size());
        System.out.println();
        System.out.println("Program continues...");
    }
}
