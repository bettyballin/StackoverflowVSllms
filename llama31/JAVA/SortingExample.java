import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        // Create a sorted list
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            sortedList.add(i);
        }

        // Add new items to the end of the list
        List<Integer> newItems = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            newItems.add((int) (Math.random() * 1000));
        }
        sortedList.addAll(newItems);

        // Sort the entire list
        Collections.sort(sortedList);

        // Alternatively, use binary search to insert each new item into the sorted list
        List<Integer> sortedList2 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            sortedList2.add(i);
        }
        for (Integer newItem : newItems) {
            int index = Collections.binarySearch(sortedList2, newItem);
            if (index < 0) {
                index = -index - 1;
            }
            sortedList2.add(index, newItem);
        }
    }
}