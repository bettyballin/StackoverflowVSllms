import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyClass {
    private Connection con;
    private boolean isAutoCommitEnabled;

    private boolean executeBatch(PreparedStatement preparedStatement) {
        try {
            if (con != null && !preparedStatement.isClosed()) {
                // Check if connection is opened and statement is open before executing batch()
                if (!isAutoCommitEnabled) {
                    con.setAutoCommit(true); // Switch autocommit to true
                }
                try {
                    preparedStatement.executeBatch();
                } catch (SQLException ex) {
                    return false; // False means failed, true means success
                }
                // executeBatch will be a single network round-trip and thus faster than many individual trips...
            } else {
                con.setAutoCommit(true);
                // rest of your code
            }
            if (!isAutoCommitEnabled) {
                con.close(); // If auto commit was false before, then close the connection as well
            }
        } catch (SQLException e) {
            // Handle exception
            return false;
        }
        return true;
    }
}