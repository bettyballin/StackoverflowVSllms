import java.util.HashMap;
import java.util.Map;

public class Main_522 {
    public static void main(String[] args) {
        // Assume you have a Java object called 'data'
        Map<String, String> data = new HashMap<>();
        data.put("key", "value"); // Replace with your actual data

        // Simple way to convert to JSON-like string without external libraries
        String json = data.toString();

        // In your JSP, use the 'json' variable to output the JSON data
        System.out.println(json);
    }
}