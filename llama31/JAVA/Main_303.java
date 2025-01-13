import java.util.Arrays;
import java.util.List;

public class Main_303 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(",");
        }
        String result = sb.deleteCharAt(sb.length() - 1).toString();
        System.out.println(result); // Output: apple,banana,cherry
    }
}