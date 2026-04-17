public class UC18_LinearSearch {
    
    /**
     * Performs a linear search to find a bogie ID in an unsorted array.
     * 
     * @param bogies    Array of bogie IDs
     * @param searchKey The ID to search for
     * @return true if the bogie exists, false otherwise
     */
    public static boolean searchBogie(String[] bogies, String searchKey) {
        if (bogies == null || searchKey == null) {
            return false;
        }

        // Sequentially traverse the array
        for (String bogie : bogies) {
            // Equality comparison
            if (bogie != null && bogie.equals(searchKey)) {
                // Match found, search stops (Early Termination)
                return true; 
            }
        }
        
        // Traversed entire array, match not found
        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Searching for bogie ID: " + searchKey);
        
        boolean found = searchBogie(bogies, searchKey);
        if (found) {
            System.out.println("Result: Bogie " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie " + searchKey + " was NOT found in the consist.");
        }
    }
}
