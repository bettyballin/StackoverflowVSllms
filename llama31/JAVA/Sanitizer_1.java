import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer_1 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespace
        input = input.trim();

        // Note: Java does not have a direct equivalent to mysql_real_escape_string.
        // It is recommended to use PreparedStatements instead.
        // However, for the sake of this example, I'll use a basic string replacement.
        input = input.replace("'", "''");

        return input;
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        System.out.println(sanitize(input));
    }
}