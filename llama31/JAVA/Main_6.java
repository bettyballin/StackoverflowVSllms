import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_6 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespace
        input = input.trim();
        
        // Escape special characters to prevent SQL injection
        // Note: This is not recommended in production code. 
        // You should use PreparedStatements instead.
        input = input.replace("'", "\\'");
        input = input.replace("\"", "\\\"");
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}