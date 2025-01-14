// Example of validating JSON in a string using Gson in Java
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonValidator {
    public static boolean isValidJson(String jsonInString) {
        try {
            final Gson gson = new Gson();
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        String jsonString = "{\"a\":[\"b\",\"c\"]}";
        System.out.println("Is the JSON valid? " + isValidJson(jsonString));
    }
}