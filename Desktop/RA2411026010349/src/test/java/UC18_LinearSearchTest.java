import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC18_LinearSearchTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG309"), "Should return true for found bogie");
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UC18_LinearSearch.searchBogie(bogies, "BG999"), "Should return false for non-existent bogie");
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG101"), "Should return true for first element match");
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG550"), "Should return true for last element match");
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG101"), "Should return true for single element match");
    }
}
