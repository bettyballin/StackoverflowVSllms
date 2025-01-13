import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDeleter {

    public static void main(String[] args) {
        // Create a connection to the database (replace with your actual database connection)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Create a temporary table with the list of values
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TEMPORARY TABLE values_to_delete (id INT)");

            // Insert the values into the temporary table
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO values_to_delete VALUES (?)");
            int[] valuesToDelete = {1, 2, 3, 4, 5}; // Replace with your actual values
            for (int id : valuesToDelete) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }

            // Perform the batch delete operation
            pstmt = conn.prepareStatement("DELETE FROM foo WHERE id IN (SELECT id FROM values_to_delete)");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}