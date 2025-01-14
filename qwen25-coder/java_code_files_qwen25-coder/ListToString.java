import java.util.Arrays;
import java.util.List;

public class ListToString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "cherry");
        String result = String.join(",", stringList);
        System.out.println(result);  // Output: apple,banana,cherry
    }
}