import java.util.ArrayList;
import java.util.Arrays;

public class Main_69 {
    public static void main(String[] args) {
        ArrayList<String> ids = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        String result = String.join(",", ids);
        System.out.println(result); // Output: 1,2,3,4
    }
}