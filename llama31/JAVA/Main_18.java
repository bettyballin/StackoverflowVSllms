import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_18 {
    public static String sanitize(String input) {
        input = input.trim();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "username", "password");
            input = conn.nativeSQL(input);
            conn.close(); // Close the connection to prevent resource leak
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return input;
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(sanitize(" test input "));
    }
}