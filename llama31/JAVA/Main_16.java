import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_16 {
    public static String sanitize(String input) {
        // Trim the input
        input = input.trim();

        // Escape special characters to prevent SQL injection
        // Note: Java's prepared statements are a better way to prevent SQL injection
        input = input.replace("'", "''");

        return input;
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "Hello, World!";
        String sanitizedInput = sanitize(input);
        System.out.println(sanitizedInput);
    }
}