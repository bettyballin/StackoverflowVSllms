import java.lang.String;

public class StringSanitizer {
    public static String removeNonAlphanumeric(String input) {
        return input.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(removeNonAlphanumeric("Hello, World!"));
    }
}