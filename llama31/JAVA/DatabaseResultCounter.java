import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResultCounter {
    public static void main(String[] args) {
        // You would typically get a ResultSet from a database query
        // For demonstration purposes, assume resultSet is a valid ResultSet
        ResultSet resultSet = null; // Initialize with a real ResultSet

        try {
            if (resultSet != null) {
                resultSet.last();
                int rowCount = resultSet.getRow();
                System.out.println("Row count: " + rowCount);
            } else {
                System.out.println("ResultSet is null");
            }
        } catch (SQLException e) {
            System.err.println("Error processing ResultSet: " + e.getMessage());
        }
    }
}