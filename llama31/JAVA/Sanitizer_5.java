import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer_5 {
    public static String sanitize(String input) {
        input = input.trim();

        // Note: Java doesn't have a direct equivalent of mysql_real_escape_string.
        // You should use prepared statements instead of escaping strings manually.
        // Here's an example of how you can use prepared statements in Java:
        // https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html

        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("   Hello, World!   "));
    }
}