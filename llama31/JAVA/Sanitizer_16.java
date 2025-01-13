import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer_16 {
    public static String sanitize(String input) {
        // trim the input
        input = input.trim();

        // escape special characters for MySQL
        input = input.replace("\\", "\\\\");
        input = input.replace("'", "\\'");
        input = input.replace("\"", "\\\"");

        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}