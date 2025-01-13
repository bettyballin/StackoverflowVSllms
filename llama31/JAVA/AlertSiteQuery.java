import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertSiteQuery {
    public static void main(String[] args) {
        // Specify the database connection URL, username, and password
        String url = "jdbc:sqlserver://your_database_server:1433;databaseName=your_database_name";
        String username = "your_username";
        String password = "your_password";
        int siteId = 1; // Replace with your site ID

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM alerts WHERE site_id IN (SELECT * FROM dbo.udf_get_event_sitelist(?))";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, siteId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        // Process the result set
                        System.out.println(rs.getString(1)); // Replace with your column index or name
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}