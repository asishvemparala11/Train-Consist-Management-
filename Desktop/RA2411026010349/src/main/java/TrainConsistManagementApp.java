import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Train Consist Management App
 * UC9: Group Bogies by Type (Collectors.groupingBy)
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

        // UC9: Group Bogies by Type (Collectors.groupingBy)
        System.out.println("--- UC9: Group Bogies by Type (Collectors.groupingBy) ---");
        System.out.println();

        // Create a List<Bogie> with multiple bogies, including duplicates
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));  // Duplicate
        bogies.add(new Bogie("AC Chair", 96)); // Duplicate

        // Display all bogies
        System.out.println("All bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Group bogies by type using Collectors.groupingBy
        System.out.println("Grouping bogies by type...");
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
        System.out.println("Grouping completed.");
        System.out.println();

        // Display grouped bogies
        System.out.println("Grouped bogies by type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            String type = entry.getKey();
            List<Bogie> group = entry.getValue();
            System.out.println("Type: " + type + " (" + group.size() + " bogies)");
            for (int i = 0; i < group.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + group.get(i));
            }
            System.out.println();
        }

        System.out.println("Key Benefits of Collectors.groupingBy:");
        System.out.println("✓ Transforms flat data into categorized structures");
        System.out.println("✓ Enables structured reporting and analysis");
        System.out.println("✓ Introduces advanced stream collectors");
        System.out.println("✓ Improves data organization for dashboards");
        System.out.println("✓ Builds foundation for analytics operations");
        System.out.println();

        System.out.println("Program continues...");
    }
}
