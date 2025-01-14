public class SanitizerUtils {
    // Example of a secure method ensuring user input is sanitized
    public String sanitizeInput(String userInput) {
        return userInput.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] args) {
    }
}