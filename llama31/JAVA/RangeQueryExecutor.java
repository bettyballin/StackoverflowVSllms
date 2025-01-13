import java.sql.*;

public class RangeQueryExecutor {
    public static void main(String[] args) throws SQLException {
        // Initialize the database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

        // Create a PreparedStatement object
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM your_table WHERE left_bound > ? AND right_bound < ?");

        // Set the parameters
        int leftBound = 10;  // replace with your value
        int rightBound = 20;  // replace with your value
        ps.setInt(1, leftBound);
        ps.setInt(2, rightBound);

        // Execute the query
        ResultSet results = ps.executeQuery();

        // Process the results
        while (results.next()) {
            // Handle the result set
            System.out.println(results.getString(1));  // replace with your handling logic
        }

        // Close the resources
        results.close();
        ps.close();
        conn.close();
    }
}