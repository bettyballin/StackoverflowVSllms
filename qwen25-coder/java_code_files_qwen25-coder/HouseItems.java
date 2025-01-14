import java.util.*;

public class HouseItems {
    public static void main(String[] args) {
        // Arrays representing items
        String[] allItems = {"Table", "Chair", "TV", "Fireplace", "Bed"};
        String[] houseItems = {"Table", "TV", "Bed"};

        // Convert arrays to sets for quick look-up
        Set<String> allItemsSet = new HashSet<>(Arrays.asList(allItems));
        Set<String> houseItemsSet = new HashSet<>(Arrays.asList(houseItems));

        // Prepare the HAS and NEEDS list boxes
        List<String> hasListBox = new ArrayList<>();
        List<String> needsListBox = new ArrayList<>();

        // Populate the "HAS" list box
        for (String item : allItems) {
            if (houseItemsSet.contains(item)) {
                hasListBox.add(item);
            }
        }

        // Populate the "NEEDS" list box
        for (String item : allItems) {
            if (!houseItemsSet.contains(item)) {
                needsListBox.add(item);
            }
        }

        // Output results
        System.out.println("HAS items: " + hasListBox);
        System.out.println("NEEDS items: " + needsListBox);
    }
}