import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInserter {
    public static void main(String[] args) {
        // Assuming you have a Connection object named connection
        Connection connection = null;
        try {
            // Assuming you're using JDBC
            connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO mytable (name) VALUES (?)");
            String userInput = "example_input"; // Replace with actual user input
            pstmt.setString(1, userInput); // userInput is the string entered by the user
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}