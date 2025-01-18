import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SafeQueryExecutor {
    // Example with PreparedStatement in Java to prevent SQL injection:

    public static void main(String[] args) {
        String query = "SELECT * FROM table WHERE column1 = ?"; // ? are placeholders for parameters
        Connection conn = null; // Assume we have a connection object 'conn'
        int intValue = 0; // Assume intValue is provided

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, intValue);
            ResultSet rs = stmt.executeQuery();
            // Process result set here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}