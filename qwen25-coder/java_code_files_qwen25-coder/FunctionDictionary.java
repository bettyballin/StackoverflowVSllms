import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionDictionary {
    private Map<String, Function<Integer, Integer>> functionMap = new HashMap<>();

    public FunctionDictionary() {
        // Populate the map with functions
        functionMap.put("increment", x -> x + 1);
        functionMap.put("decrement", x -> x - 1);
        functionMap.put("double", x -> x * 2);
    }

    public Integer executeFunction(String key, Integer input) {
        Function<Integer, Integer> function = functionMap.get(key);
        if (function != null) {
            return function.apply(input);
        } else {
            throw new IllegalArgumentException("No such function: " + key);
        }
    }

    public static void main(String[] args) {
        FunctionDictionary dict = new FunctionDictionary();
        System.out.println(dict.executeFunction("increment", 5)); // Output: 6
        System.out.println(dict.executeFunction("double", 3));    // Output: 6
        try {
            System.out.println(dict.executeFunction("triple", 2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: No such function: triple
        }
    }
}