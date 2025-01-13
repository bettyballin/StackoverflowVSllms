import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_10 {
    public static String sanitize(String input) {
        // trim() method in Java is used to remove leading and trailing whitespaces
        input = input.trim();
        
        // In Java, we use PreparedStatements to prevent SQL injection
        // But if you still want to escape a string manually, you can use this method
        input = input.replace("'", "''");
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, World!"));
    }
}