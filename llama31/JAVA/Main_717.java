import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_717 {
    public static void main(String[] args) {
        // Example input from user
        String userInput = "Example User Input";

        // Escape HTML special characters
        String escapedInput = escapeHtml(userInput);
        // Use the escaped input in your JSP page
        System.out.println(escapedInput);
    }

    private static String escapeHtml(String input) {
        // Using regex to escape HTML special characters
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&#x27;");
    }
}