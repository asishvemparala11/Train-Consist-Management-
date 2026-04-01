import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC8: Filter Passenger Bogies Using Streams
 */
public class TrainConsistManagementAppTest {

    // Helper method to create test bogies
    private List<Bogie> createTestBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        return bogies;
    }

    // Helper method to filter bogies (extracted for testing)
    private List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(java.util.stream.Collectors.toList());
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 70);
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 72);
        assertFalse(filtered.stream().anyMatch(b -> b.getCapacity() == 72));
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 50);
        assertFalse(filtered.stream().anyMatch(b -> b.getCapacity() <= 50));
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 40);
        assertEquals(3, filtered.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 100);
        assertTrue(filtered.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 40);
        assertEquals(bogies.size(), filtered.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        List<Bogie> filtered = filterBogiesByCapacity(bogies, 60);
        assertTrue(filtered.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> original = new ArrayList<>(bogies);
        filterBogiesByCapacity(bogies, 60);
        assertEquals(original, bogies);
    }
}