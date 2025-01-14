import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main_70 {
    public static void main(String[] args) {
        ArrayList<String> ids = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        String result = ids.stream().collect(Collectors.joining(","));
        System.out.println(result); // Output: 1,2,3,4
    }
}