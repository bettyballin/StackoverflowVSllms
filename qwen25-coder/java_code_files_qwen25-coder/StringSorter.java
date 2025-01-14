import java.lang.String;
import java.util.Arrays;

public class StringSorter {
    public static void main(String[] args) {
        String[] strings = {"banana", "apple", "orange", "mango"};
        
        // Sorting the array in ascending order
        Arrays.sort(strings);
        
        // Printing sorted array
        System.out.println("Sorted Array: " + Arrays.toString(strings));
    }
}