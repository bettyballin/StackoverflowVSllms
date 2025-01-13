import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseQueryExecutor_13_13 {
    public static void main(String[] args) {
        // Assuming you have a Connection object named 'conn'
        String userInput = "someUserInput";

        // Create a connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a prepared statement with a parameterized query
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

            // Set the user input as a parameter
            pstmt.setString(1, userInput);

            // Execute the query
            ResultSet results = pstmt.executeQuery();

            // Process the results
            while (results.next()) {
                // Do something with the results
                System.out.println(results.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}