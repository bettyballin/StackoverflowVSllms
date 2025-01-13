import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SequenceFetcher {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password")) {
            CallableStatement cs = conn.prepareCall("BEGIN fetch_ids(?, ?); END;");
            cs.setString(1, "my_sequence");
            cs.setInt(2, 100);
            cs.execute();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}