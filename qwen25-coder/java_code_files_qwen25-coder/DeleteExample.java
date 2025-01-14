import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {
    public static void deleteKeys(Connection connection, long[] keysToDelete) throws SQLException {
        if (keysToDelete.length == 0) return;

        StringBuilder sql = new StringBuilder("DELETE FROM MyTable WHERE myPrimaryKey IN (?");
        for (int i = 1; i < keysToDelete.length; i++) {
            sql.append(", ?");
        }
        sql.append(")");

        try (PreparedStatement pstmt = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < keysToDelete.length; i++) {
                pstmt.setLong(i + 1, keysToDelete[i]);
            }
            pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        // Example usage with a sample connection
        try (Connection conn = getConnection()) {
            long[] keysToDelete = {0, 1, 2, 3};
            deleteKeys(conn, keysToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Placeholder method for obtaining a database connection
    private static Connection getConnection() throws SQLException {
        // Implement your database connection logic here
        return null;
    }
}