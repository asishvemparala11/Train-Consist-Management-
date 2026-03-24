import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        System.out.println("--- UC5: Preserve Insertion Order with LinkedHashSet ---");
        System.out.println();

        // Create a LinkedHashSet<String> to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies: Engine, Sleeper, Cargo, Guard
        System.out.println("Attaching bogies to train formation...");
        trainFormation.add("Engine");
        System.out.println("Added: Engine");
        trainFormation.add("Sleeper");
        System.out.println("Added: Sleeper");
        trainFormation.add("Cargo");
        System.out.println("Added: Cargo");
        trainFormation.add("Guard");
        System.out.println("Added: Guard");
        System.out.println();

        // Attempt to attach a duplicate bogie intentionally (Sleeper again)
        System.out.println("Attempting to attach duplicate bogie (Sleeper)...");
        boolean sleeper_duplicate = trainFormation.add("Sleeper");
        if (!sleeper_duplicate) {
            System.out.println("Notice: Sleeper not added (duplicate ignored - auto-deduplication by LinkedHashSet)");
        }
        System.out.println();

        // Attempt another duplicate
        System.out.println("Attempting to attach another duplicate bogie (Cargo)...");
        boolean cargo_duplicate = trainFormation.add("Cargo");
        if (!cargo_duplicate) {
            System.out.println("Notice: Cargo not added (duplicate ignored - auto-deduplication by LinkedHashSet)");
        }
        System.out.println();

        // Display the final formation order using System.out.println()
        System.out.println("Final Train Formation (maintaining insertion order with uniqueness):");
        int position = 1;
        for (String bogie : trainFormation) {
            System.out.println(position + ". " + bogie);
            position++;
        }
        System.out.println("Total unique bogies: " + trainFormation.size());
        System.out.println();

        // Display key characteristics
        System.out.println("Formation Details:");
        System.out.println("- Original order preserved: Engine -> Sleeper -> Cargo -> Guard");
        System.out.println("- Duplicate attempts rejected: 2 attempted duplicates (Sleeper, Cargo)");
        System.out.println("- Final composition: " + trainFormation.toString());
        System.out.println();

        System.out.println("Key Benefits of LinkedHashSet:");
        System.out.println("✓ Enforces real-world business rules (no duplicate bogies)");
        System.out.println("✓ Preserves physical attachment sequence of the train");
        System.out.println("✓ Combines ordering with uniqueness (SetInterface)");
        System.out.println("✓ Better than HashSet for maintaining insertion order");
        System.out.println("✓ Better than List for enforcing uniqueness");
        System.out.println("✓ Predictable train composition logic");
        System.out.println();

        System.out.println("Program continues...");
    }
}
