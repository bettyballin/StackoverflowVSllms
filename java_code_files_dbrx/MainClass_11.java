import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // Import SQLException

public class MainClass {

    public static void main(String[] args) throws Exception {

        try (Connection conn = getDBConnection()) {
            PreparedStatement ps = null;
            try {
                // Prepare query here;
                String sql = "SELECT * FROM mytable"; // Example query
                ps = conn.prepareStatement(sql);
                ResultSet rs = null;
                try {
                    rs = ps.executeQuery();  // Execute the query
                    while (rs.next()) {
                        // Processing goes here...
                        boolean isTaskRunning = true; // Example value
                        if (!isTaskRunning) {    // Check if task is running or cancel request received/processed
                            try {
                                ps.cancel();       // Cancel statement execution
                            } catch (SQLException e) {
                                // Handle SQLException
                            }
                            break;
                        }
                    }
                    rs.close();  // Closes resultset when done
                } catch (Exception e) {
                    // Handle Exception
                } finally {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            // Handle SQLException
                        }
                    }
                }
            } catch (Exception e) {
                // Handle Exception
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        // Handle SQLException
                    }
                }
            }
        } catch (Exception e) {
            // Handle Exception
        }
    }

    private static Connection getDBConnection() throws Exception {
        // Return a connection or throw an exception
        return null; // Replace with actual code to get connection
    }
}