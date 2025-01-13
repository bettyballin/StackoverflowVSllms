import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderInserter {
    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a prepared statement
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (amount, tax, total) VALUES (?, ?, ?)");

            // Set values for the prepared statement
            stmt.setBigDecimal(1, new BigDecimal("100.00"));
            stmt.setBigDecimal(2, new BigDecimal("8.00"));
            stmt.setBigDecimal(3, new BigDecimal("108.00"));

            // Execute the update
            stmt.executeUpdate();

            // Close the statement and connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}