import java.util.List;
import java.util.Arrays;

public class StringJoinerExample {

    List<String> collectionOfStrings = Arrays.asList("34", "26", "2");
    String result = String.join(",", collectionOfStrings);

    public static void main(String[] args) {
    }
}