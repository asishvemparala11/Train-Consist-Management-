import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Train Consist Management App
 * UC8: Filter Passenger Bogies Using Streams
 */

/**
 * Bogie class to represent a train bogie with name and capacity.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC8: Filter Passenger Bogies Using Streams
        System.out.println("--- UC8: Filter Passenger Bogies Using Streams ---");
        System.out.println();

        // Create a List<Bogie> to store passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));

        // Display all bogies
        System.out.println("All passenger bogies:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Filter bogies with capacity > 60 using streams
        System.out.println("Filtering bogies with seating capacity > 60...");
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        System.out.println("Filtering completed.");
        System.out.println();

        // Display filtered bogies
        System.out.println("Filtered bogies (capacity > 60):");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the filter criteria.");
        } else {
            for (int i = 0; i < filteredBogies.size(); i++) {
                System.out.println((i + 1) + ". " + filteredBogies.get(i));
            }
        }
        System.out.println();

        System.out.println("Key Benefits of Stream API:");
        System.out.println("✓ Declarative filtering without manual loops");
        System.out.println("✓ Concise and readable business logic");
        System.out.println("✓ Functional programming style");
        System.out.println("✓ Improves code maintainability");
        System.out.println("✓ Prepares for advanced stream operations");
        System.out.println();

        System.out.println("Program continues...");
    }
}
