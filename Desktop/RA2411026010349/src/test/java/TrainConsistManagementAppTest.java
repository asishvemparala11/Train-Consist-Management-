import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * JUnit tests for TrainConsistManagementApp
 * UC7: Sort Bogies Using Comparator
 */
public class TrainConsistManagementAppTest {

    @Test
    public void testBogieCreation() {
        Bogie bogie = new Bogie("Test Bogie", 100);
        assertEquals("Test Bogie", bogie.getName());
        assertEquals(100, bogie.getCapacity());
    }

    @Test
    public void testBogieToString() {
        Bogie bogie = new Bogie("Sleeper", 72);
        assertEquals("Sleeper (72 seats)", bogie.toString());
    }

    @Test
    public void testComparatorSortingAscending() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        assertEquals(48, bogies.get(0).getCapacity());
        assertEquals(72, bogies.get(1).getCapacity());
        assertEquals(96, bogies.get(2).getCapacity());
    }

    @Test
    public void testComparatorSortingDescending() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        assertEquals(96, bogies.get(0).getCapacity());
        assertEquals(72, bogies.get(1).getCapacity());
        assertEquals(48, bogies.get(2).getCapacity());
    }

    @Test
    public void testEmptyListSorting() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        assertTrue(bogies.isEmpty());
    }
}