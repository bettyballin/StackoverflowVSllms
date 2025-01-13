import java.util.*;

public class Main_537_537 {
    public static void main(String[] args) {
        // Create an ArrayList with repeated elements
        List<String> listWithDuplicates = new ArrayList<>(Arrays.asList("Apple", "Banana", "Apple", "Cherry", "Banana", "Date"));

        // Convert the ArrayList to a HashSet to remove duplicates
        Set<String> setWithoutDuplicates = new HashSet<>(listWithDuplicates);

        // Convert the HashSet back to a List
        List<String> listWithoutDuplicates = new ArrayList<>(setWithoutDuplicates);

        // Print the list without duplicates
        System.out.println(listWithoutDuplicates);
    }
}