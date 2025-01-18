import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> c = Arrays.asList("Apple", "Banana");
        String[] a = new String[c.size()]; // Create new string array with enough space for all elements in list c
        a = c.toArray(a);                  // Fill the newly created a array with objects converted from List<String> to String[] type
    }
}