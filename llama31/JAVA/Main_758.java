import java.util.Arrays;
import java.util.List;

public class Main_758 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("foo", "bar", "baz");
        String item = "bar";

        int index = myList.indexOf(item);
        System.out.println(index);  // Output: 1
    }
}