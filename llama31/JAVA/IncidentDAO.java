import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncidentDAO {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the database driver (e.g., MySQL Connector/J)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO incident (incident_number) VALUES (?)");
            pstmt.setString(1, "I?");
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}