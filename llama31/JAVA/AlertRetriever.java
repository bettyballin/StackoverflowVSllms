import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertRetriever {
    public static void main(String[] args) {
        AlertRetriever retriever = new AlertRetriever();
        retriever.run();
    }

    public void run() {
        String sql = "SELECT a.id AS alertId, a.location_id, a.alert_type_id, a.event_id, a.user_id, a.site_id, a.accepted_by FROM alerts AS a JOIN alert_types AS ats ON a.alert_type_id = ats.id JOIN events AS tr ON a.event_id = tr.event_id WHERE tr.end_Time IS null AND tr.status_id = 0 AND ats.code = 'E' AND a.site_id IN (SELECT * FROM dbo.udf_get_event_sitelist(?))";
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            int siteId = 1; // Replace with actual site ID
            stmt.setInt(1, siteId);
            ResultSet rs = stmt.executeQuery();
            // Process the result set
            while (rs.next()) {
                // Process each row
            }
        } catch (SQLException e) {
            // Handle SQL exception
        }
    }

    // Replace with actual connection establishment code
    private Connection getConnection() throws SQLException {
        // For demonstration purposes, assume a connection is established
        return null;
    }
}