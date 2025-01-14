import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRowHandler {
    private Connection connection;
    private static final int YOUR_DATABASE_ERROR_CODE_FOR_DUPLICATE_KEY = 0; // Replace with your database's duplicate key error code

    boolean insertRow(String key) {
        try {
            // Attempt to insert directly into the table
            String sql = "INSERT INTO mytable (key) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, key);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Catch the specific exception for duplicate keys if supported by your database
            if (e.getErrorCode() == YOUR_DATABASE_ERROR_CODE_FOR_DUPLICATE_KEY) {
                return false;
            }
            // Rethrow or handle other SQL exceptions as needed
            throw new RuntimeException("Failed to insert row", e);
        }
    }

    public static void main(String[] args) {
    }
}