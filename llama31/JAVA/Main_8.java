import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_8 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespaces
        input = input.trim();

        // Escape special characters for MySQL
        input = input.replace("\\", "\\\\");
        input = input.replace("'", "\\'");
        input = input.replace("\"", "\\\"");

        return input;
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        System.out.println(sanitize(input));
    }
}