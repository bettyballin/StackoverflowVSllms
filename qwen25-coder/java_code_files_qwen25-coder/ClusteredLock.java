import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClusteredLock {

    private static final String LOCK_TABLE = "DB_UPGRADE_LOCK";
    private static final String LOCK_KEY = "upgrade_lock_key";

    public boolean acquireLock(Connection connection) throws SQLException {
        // Attempt to insert the lock record
        String insertSql = "INSERT INTO " + LOCK_TABLE + " (lock_key, node_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
            insertStmt.setString(1, LOCK_KEY);
            insertStmt.setString(2, getNodeIdentifier());
            int updateCount = insertStmt.executeUpdate();
            return updateCount == 1;
        } catch (SQLException e) {
            // Check if the lock already exists
            String selectSql = "SELECT node_id FROM " + LOCK_TABLE + " WHERE lock_key = ?";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectSql)) {
                selectStmt.setString(1, LOCK_KEY);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        // Log that another node is performing the upgrade
                        System.out.println("Lock already held by: " + rs.getString("node_id"));
                    }
                }
            }
            throw e;
        }
    }

    private String getNodeIdentifier() {
        // Implement how you identify your nodes, for example using system properties or a config file
        return System.getProperty("NODE_ID");
    }

    public boolean releaseLock(Connection connection) throws SQLException {
        String deleteSql = "DELETE FROM " + LOCK_TABLE + " WHERE lock_key = ? AND node_id = ?";
        try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
            deleteStmt.setString(1, LOCK_KEY);
            deleteStmt.setString(2, getNodeIdentifier());
            return deleteStmt.executeUpdate() == 1;
        }
    }

	public static void main(String[] args) {
	}
}