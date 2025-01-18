import java.lang.String;
import java.util.Arrays;
public class FruitSorter {
    static String[] strArray = {"apple", "banana", "kiwi", "mango"};  // Input array

    static {
        Arrays.sort(strArray);                    // Sort the array in ascending order
        for (String s : strArray) {              // Print out sorted elements
             System.out.println(s);               // for verification
        }
    }

    public static void main(String[] args) {
    }
}