import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer_3 {
    public static String sanitize(String input) {
        // Trim the input
        input = input.trim();

        // Escape special characters to prevent SQL injection
        // Note: In Java, we use PreparedStatements to prevent SQL injection, 
        // but for the sake of this example, we'll use a manual approach
        input = input.replace("'", "''");

        return input;
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String sanitizedInput = sanitize(input);
        System.out.println(sanitizedInput);
    }
}