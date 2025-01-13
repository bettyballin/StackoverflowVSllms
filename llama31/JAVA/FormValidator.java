import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FormValidator {
    public static void main(String[] args) {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("key", "ETC"); // simulate a request parameter

        String selectedValue = requestParams.get("key");
        if (selectedValue.equals("ETC")) {
            System.out.println("Please select an option.");
        } else {
            System.out.println("Form submission successful.");
        }
    }
}