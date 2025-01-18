import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionDictionary {
    public static void main(String[] args) {
        Map<String, Function<Integer, Integer>> dict = new HashMap<>();
        // Key is String and Value is Functions which take an integer and return an integer

        dict.put("square", x -> x * x);
        dict.put("increment", x -> x + 1);
        dict.put("decrement", x -> x - 1);

        // To call a function:
        int num = 5;
        System.out.println(dict.get("square").apply(num));    // Prints 25
        System.out.println(dict.get("increment").apply(num)); // Prints 6
        System.out.println(dict.get("decrement").apply(num)); // Prints 4
    }
}