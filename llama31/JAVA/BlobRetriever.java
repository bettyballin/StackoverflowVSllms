import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobRetriever {
    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
            return;
        }

        // Establish a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            return;
        }

        // Use a prepared statement to retrieve a blob
        try (PreparedStatement stmt = connection.prepareStatement("SELECT contents FROM documents WHERE id = ?")) {
            stmt.setInt(1, 1);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    byte[] contents = rs.getBytes(1);
                    // Process the blob contents
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving blob: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}