import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_9 {

    public static String sanitize(String input) {
        // trim() is a method in Java String class that removes leading and trailing whitespace
        input = input.trim();

        // Java does not have a direct equivalent of mysql_real_escape_string, 
        // but you can use the String.replace() method to achieve similar results
        input = input.replace("'", "\\'");
        input = input.replace("\"", "\\\"");

        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}