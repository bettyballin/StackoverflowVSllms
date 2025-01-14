import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInsert {
    public void insertData(Connection connection, String query) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            // Check the SQLState to determine if it's a duplicate key error
            if ("23505".equals(ex.getSQLState())) { // 23505 is the standard SQLState for unique constraint violation
                System.out.println("Duplicate key encountered.");
            } else {
                throw ex; // Re-throw the exception if it's not a duplicate key error
            }
        }
    }

	public static void main(String[] args) {
	}
}