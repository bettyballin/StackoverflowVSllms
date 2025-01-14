import java.util.HashMap;
import java.util.Map;

public class FunctionMapper {
    private static final Map<String, Runnable> lookup = new HashMap<>();

    // Define some functions to be mapped
    private static void function1() {
        System.out.println("Function 1 called");
    }

    private static void function2() {
        System.out.println("Function 2 called");
    }

    private static void function3() {
        System.out.println("Function 3 called");
    }

    public static void main(String[] args) {
        // Populate the map with function names and corresponding functions
        lookup.put("function1", FunctionMapper::function1);
        lookup.put("function2", FunctionMapper::function2);
        lookup.put("function3", FunctionMapper::function3);

        // Example input
        String input = "function2";

        // Call the function based on input
        if (lookup.containsKey(input)) {
            lookup.get(input).run();
        } else {
            System.out.println("No such function");
        }
    }
}