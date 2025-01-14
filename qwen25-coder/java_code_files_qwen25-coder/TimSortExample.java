import java.lang.String;
import java.util.Arrays;

public class TimSortExample {
    public static void main(String[] args) {
        int[] array = {5, 21, 7, 23, 19};
        Arrays.sort(array); // Java's Arrays.sort() uses Timsort under the hood for objects
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}