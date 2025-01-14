import java.sql.PreparedStatement;
import java.sql.Connection;

public class IncidentUpdater {
    public static void main(String[] args) {
        String sql = "INSERT INTO DB..incident (incident_number) VALUES (?)";
        Connection connection = null; // Initialize your connection here
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "I?");
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}