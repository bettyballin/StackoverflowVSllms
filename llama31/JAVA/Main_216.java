import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main_216_216 {
    public static void main(String[] args) {
        Map<String, Function<String, String>> functions = new HashMap<>();

        // Add a function to the map
        functions.put("uppercase", String::toUpperCase);

        // Add a lambda expression to the map
        functions.put("greet", name -> "Hello, " + name + "!");

        // Call a function from the map
        String result = functions.get("uppercase").apply("hello");
        System.out.println(result); // prints "HELLO"

        // Call a lambda expression from the map
        String greeting = functions.get("greet").apply("John");
        System.out.println(greeting); // prints "Hello, John!"
    }
}