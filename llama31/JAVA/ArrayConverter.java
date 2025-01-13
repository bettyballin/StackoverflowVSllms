import java.util.Arrays;
import java.util.List;

public class ArrayConverter {
    public static void main(String[] args) {
        ArrayConverter converter = new ArrayConverter();
        List<String> c = Arrays.asList("a", "b", "c");
        String[] a = c.toArray(new String[0]); // returns a String[] with 3 elements
    }
}