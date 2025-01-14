import java.lang.String;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DataArchiver {

    private static final String DB_URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public void archiveHistoricalData() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO history SELECT * FROM active WHERE timestamp < ?")) {

            // Set the date to filter historical records
            stmt.setTimestamp(1, Timestamp.valueOf("2023-01-01 00:00:00"));

            // Execute insert into history table
            stmt.executeUpdate();

            // Now delete from active table
            try (PreparedStatement deleteStmt = conn.prepareStatement(
                "DELETE FROM active WHERE timestamp < ?")) {
                deleteStmt.setTimestamp(1, Timestamp.valueOf("2023-01-01 00:00:00"));
                deleteStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DataArchiver archiver = new DataArchiver();
        archiver.archiveHistoricalData();
    }
}