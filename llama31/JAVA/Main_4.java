import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_4 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespace
        input = input.trim();

        // Escape special characters
        input = input.replace("'", "''");
        input = input.replace("\"", "\"\"");

        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}