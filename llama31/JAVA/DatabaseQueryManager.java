import java.sql.*;

public class DatabaseQueryManager {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Load database driver
            Class.forName("jdbc.driver.class.Name");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:database:connection:string");

            ps = conn.prepareStatement("SELECT * FROM my_table");
            ps.executeQuery();

            // Later, in another thread...
            ps.cancel();

            // Check if the query was canceled
            SQLWarning warning = ps.getWarnings();
            if (warning != null) {
                System.out.println("Query was canceled: " + warning.getMessage());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connections: " + e.getMessage());
            }
        }
    }
}