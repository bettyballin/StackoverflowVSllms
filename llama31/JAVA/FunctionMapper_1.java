import java.util.HashMap;
import java.util.Map;

public class FunctionMapper_1_1 {
    private static Map<String, Runnable> lookup = new HashMap<>();

    static {
        lookup.put("function1", () -> System.out.println("Function 1 called"));
        lookup.put("function2", () -> System.out.println("Function 2 called"));
        lookup.put("function3", () -> System.out.println("Function 3 called"));
    }

    public static void main(String[] args) {
        // Example usage:
        lookup.get("function1").run();
        lookup.get("function2").run();
        lookup.get("function3").run();
    }
}