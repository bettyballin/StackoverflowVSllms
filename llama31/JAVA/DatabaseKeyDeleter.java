import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

public class DatabaseKeyDeleter {
    public static void main(String[] args) {
        DatabaseKeyDeleter deleter = new DatabaseKeyDeleter();
        deleter.deleteKeys();
    }

    public void deleteKeys() {
        long[] keysToDelete = {0, 1, 2, 3};
        String placeholderString = String.join(",", Collections.nCopies(keysToDelete.length, "?"));
        String query = "DELETE FROM MyTable WHERE myPrimaryKey IN (" + placeholderString + ")";

        try (Connection connection = getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            for (int i = 0; i < keysToDelete.length; i++) {
                pstmt.setLong(i + 1, keysToDelete[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting keys: " + e.getMessage());
        }
    }

    // You need to implement this method to return a Connection object
    private Connection getConnection() throws SQLException {
        // Your database connection logic here
        // For example:
        // return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        throw new SQLException("Not implemented");
    }
}