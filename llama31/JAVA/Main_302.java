import java.util.Arrays;
import java.util.List;

public class Main_302 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        String result = String.join(",", list);
        System.out.println(result); // Output: apple,banana,cherry
    }
}