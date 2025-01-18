import java.util.HashMap;
import java.util.function.Supplier;

public class FunctionMapping {
    public static void main(String[] args) {
        HashMap<String, Supplier<Integer>> functionMap = new HashMap<>();
        functionMap.put("func1", () -> func1());  // Replace with your functions
        functionMap.put("func2", () -> func2());  // Here I used simple functions returning int values as an example
        functionMap.put("func3", () -> func3());

        String input = args[0];   // set input dynamically, e.g., from user or program logic

        Integer result = functionMap.get(input).get();  // call method based on the value of 'input'
    }

    private static int func1() { return 1; }
    private static int func2() { return 2; }
    private static int func3() { return 3; }
}