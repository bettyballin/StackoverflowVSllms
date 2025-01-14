import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchExample {
    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        // Assume sortedList is already populated and sorted
        Collections.addAll(sortedList, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

        int valueToFind = 7;
        int index = Collections.binarySearch(sortedList, valueToFind);

        if (index >= 0) {
            System.out.println("Value found at index: " + index);
        } else {
            System.out.println("Value not found.");
        }
    }
}