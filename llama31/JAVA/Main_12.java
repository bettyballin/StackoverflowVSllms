import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_12 {
    public static String sanitize(String input) {
        input = input.trim();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            input = conn.nativeSQL(input);
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(sanitize("Hello, World!"));
    }
}