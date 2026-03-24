import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
 * UC6: Map Bogie to Capacity (HashMap)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

       
        // UC6: Map Bogie to Capacity (HashMap)
        System.out.println("--- UC6: Map Bogie to Capacity (HashMap) ---");
        System.out.println();

        // Create a HashMap<String, Integer> to store bogie-capacity information
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Insert capacity values for bogies using the put() method
        System.out.println("Mapping bogie names to their seating/load capacities...");
        bogieCapacity.put("Sleeper", 72);
        System.out.println("Added: Sleeper -> 72 seats");
        bogieCapacity.put("AC Chair", 96);
        System.out.println("Added: AC Chair -> 96 seats");
        bogieCapacity.put("First Class", 48);
        System.out.println("Added: First Class -> 48 seats");
        bogieCapacity.put("Pantry Car", 0);
        System.out.println("Added: Pantry Car -> 0 seats (no seating)");
        bogieCapacity.put("Cargo", 500);
        System.out.println("Added: Cargo -> 500 kg capacity");
        System.out.println();

        // Iterate over the map using entrySet()
        System.out.println("Bogie Capacity Details (Key-Value Mapping):");
        System.out.println("Total bogies mapped: " + bogieCapacity.size());
        System.out.println();

        // Display each bogie along with its corresponding capacity
        int entryNo = 1;
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            String bogieName = entry.getKey();
            Integer capacity = entry.getValue();
            System.out.println(entryNo + ". " + bogieName + " -> Capacity: " + capacity);
            entryNo++;
        }
        System.out.println();

        // Fast lookup demonstration using keys
        System.out.println("Fast Lookup Demonstration (O(1) retrieval):");
        String lookupBogie = "Sleeper";
        if (bogieCapacity.containsKey(lookupBogie)) {
            Integer capacity = bogieCapacity.get(lookupBogie);
            System.out.println(lookupBogie + " has capacity: " + capacity);
        }
        System.out.println();

        // Calculate total capacity
        int totalCapacity = 0;
        System.out.println("Calculating total train capacity:");
        for (Integer capacity : bogieCapacity.values()) {
            totalCapacity += capacity;
        }
        System.out.println("Total combined capacity: " + totalCapacity);
        System.out.println();

        // Display all keys (bogie names)
        System.out.println("All bogies in the map (Keys):");
        System.out.println(bogieCapacity.keySet().toString());
        System.out.println();

        // Display all capacities
        System.out.println("All capacities in the map (Values):");
        System.out.println(bogieCapacity.values().toString());
        System.out.println();

        System.out.println("Key Benefits of HashMap:");
        System.out.println("✓ Models real-world attribute mapping (bogie -> capacity)");
        System.out.println("✓ Introduces key-value data representation");
        System.out.println("✓ Fast O(1) lookup and insertion using keys");
        System.out.println("✓ Enables validation and analytics on bogie properties");
        System.out.println("✓ Foundation for enterprise data modeling patterns");
        System.out.println();

        System.out.println("Program continues...");
    }
}
