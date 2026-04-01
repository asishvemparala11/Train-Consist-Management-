import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC9: Group Bogies by Type (Collectors.groupingBy)
 */
public class TrainConsistManagementAppTest {

    // Helper method to create test bogies with duplicates
    private List<Bogie> createTestBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        return bogies;
    }

    // Helper method to group bogies
    private Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createTestBogies();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertEquals(3, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createTestBogies();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createTestBogies();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertNotEquals(grouped.get("Sleeper"), grouped.get("AC Chair"));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createTestBogies();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertTrue(grouped.keySet().contains("Sleeper"));
        assertTrue(grouped.keySet().contains("AC Chair"));
        assertTrue(grouped.keySet().contains("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createTestBogies();
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> original = new ArrayList<>(bogies);
        groupBogiesByType(bogies);
        assertEquals(original, bogies);
    }
}