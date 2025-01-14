import java.util.*;

public class SortNumbersTest {

    public static void main(String[] args) {
        // Normal Cases
        List<Integer> numbers1 = Arrays.asList(3, 1, 4);
        assertTrue(SortNumbers(numbers1, true).equals(Arrays.asList(1, 3, 4)));
        assertTrue(SortNumbers(numbers1, false).equals(Arrays.asList(4, 3, 1)));
        
        // Edge Cases
        List<Integer> emptyList = Collections.emptyList();
        assertTrue(SortNumbers(emptyList, true).isEmpty());
        assertTrue(SortNumbers(emptyList, false).isEmpty());
        
        List<Integer> singleElementList = Arrays.asList(2);
        assertTrue(SortNumbers(singleElementList, true).equals(Arrays.asList(2)));
        assertTrue(SortNumbers(singleElementList, false).equals(Arrays.asList(2)));
        
        // Already Sorted
        List<Integer> alreadySortedAscending = Arrays.asList(1, 2, 3);
        assertTrue(SortNumbers(alreadySortedAscending, true).equals(Arrays.asList(1, 2, 3)));
        
        List<Integer> alreadySortedDescending = Arrays.asList(3, 2, 1);
        assertTrue(SortNumbers(alreadySortedDescending, false).equals(Arrays.asList(3, 2, 1)));
        
        // Reverse Sorted
        assertTrue(SortNumbers(alreadySortedDescending, true).equals(Arrays.asList(1, 2, 3)));
        assertTrue(SortNumbers(alreadySortedAscending, false).equals(Arrays.asList(3, 2, 1)));
        
        // Duplicates
        List<Integer> withDuplicates = Arrays.asList(2, 1, 2);
        assertTrue(SortNumbers(withDuplicates, true).equals(Arrays.asList(1, 2, 2)));
        assertTrue(SortNumbers(withDuplicates, false).equals(Arrays.asList(2, 2, 1)));

        System.out.println("All tests passed.");
    }
    
    public static List<Integer> SortNumbers(List<Integer> list, boolean ascending) {
        List<Integer> sortedList = new ArrayList<>(list);
        if (ascending) {
            Collections.sort(sortedList);
        } else {
            Collections.sort(sortedList, Collections.reverseOrder());
        }
        return sortedList;
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Test failed");
        }
    }
}