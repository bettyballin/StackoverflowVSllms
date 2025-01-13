import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespace
        input = input.trim();

        // Note: Java's equivalent to mysql_real_escape_string is not as straightforward,
        // and it's generally recommended to use prepared statements instead.
        // However, for the sake of conversion, we'll use a simple replacement.
        input = input.replace("'", "''"); // escape single quotes
        input = input.replace("\\", "\\\\"); // escape backslashes

        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}