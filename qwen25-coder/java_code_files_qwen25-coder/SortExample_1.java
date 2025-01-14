import java.lang.String;
import java.util.Arrays;

public class SortExample_1 {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        Arrays.sort(numbers); // Java's Arrays.sort() uses dual-pivot quicksort for primitive types, avg: O(n log n)
    }
}