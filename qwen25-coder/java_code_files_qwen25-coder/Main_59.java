import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> collectionOfStrings = Arrays.asList("34", "26", "2");
        String result = collectionOfStrings.stream().collect(Collectors.joining(","));
        System.out.println(result);
    }
}