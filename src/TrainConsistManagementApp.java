import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();


        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        System.out.println("--- UC4: Maintain Ordered Bogie IDs (LinkedList) ---");
        System.out.println();

        // Create a LinkedList<String> for the consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies: Engine, Sleeper, AC, Cargo, Guard
        System.out.println("Building train consist with LinkedList...");
        trainConsist.addLast("Engine");
        trainConsist.addLast("Sleeper");
        trainConsist.addLast("AC");
        trainConsist.addLast("Cargo");
        trainConsist.addLast("Guard");
        System.out.println("Initial consist added successfully.");
        System.out.println();

        // Display the consist before modification
        System.out.println("Initial Train Consist (in order):");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        // Insert a Pantry Car at position 2 (between Sleeper and AC)
        System.out.println("Inserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("Pantry Car inserted successfully.");
        System.out.println();

        // Display the consist after insertion
        System.out.println("Train Consist after insertion:");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        // Remove the first and last bogie
        System.out.println("Removing first bogie (Engine)...");
        String removedFirst = trainConsist.removeFirst();
        System.out.println("Removed: " + removedFirst);
        System.out.println();

        System.out.println("Removing last bogie (Guard)...");
        String removedLast = trainConsist.removeLast();
        System.out.println("Removed: " + removedLast);
        System.out.println();

        // Display the final ordered train consist
        System.out.println("Final Train Consist (after removals):");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        System.out.println("Key Benefits of LinkedList:");
        System.out.println("✓ Models real-world chaining behavior (node-based structure)");
        System.out.println("✓ Efficient insertion and deletion at head/tail O(1)");
        System.out.println("✓ Maintains insertion order (physical train sequence)");
        System.out.println("✓ Better than ArrayList for frequent insertions/deletions");
        System.out.println();

        System.out.println("Program continues...");
    }
}
