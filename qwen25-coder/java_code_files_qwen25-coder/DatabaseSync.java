import java.lang.String;
import java.sql.*;

public class DatabaseSync {
    public static void main(String[] args) throws SQLException {
        // Source (DB2) and Target (DB1) DB connection URLs, usernames, passwords
        String sourceUrl = "jdbc:oracle:thin:@//source_host:port/service_name";
        String targetUrl = "jdbc:oracle:thin:@//target_host:port/service_name";
        String username = "username";
        String password = "password";

        // SQL query to select from the source database
        String selectQuery = "SELECT * FROM TableA WHERE some_column > 100";
        // Insert query for the target database
        String insertQuery = "INSERT INTO TableA (column1, column2, column3) VALUES (?, ?, ?)";

        try (Connection sourceConn = DriverManager.getConnection(sourceUrl, username, password);
             Connection targetConn = DriverManager.getConnection(targetUrl, username, password);
             Statement selectStmt = sourceConn.createStatement();
             ResultSet rs = selectStmt.executeQuery(selectQuery);
             PreparedStatement insertStmt = targetConn.prepareStatement(insertQuery)) {

            // Fetch data from the source and insert into the target
            int batchCount = 0;
            while (rs.next()) {
                insertStmt.setObject(1, rs.getObject("column1"));
                insertStmt.setObject(2, rs.getObject("column2"));
                insertStmt.setObject(3, rs.getObject("column3"));

                insertStmt.addBatch();
                batchCount++;

                // Execute batch in chunks to prevent memory issues
                if (batchCount % 500 == 0) {
                    insertStmt.executeBatch();
                    targetConn.commit(); // Assuming autoCommit is off for bulk inserts
                }
            }

            // Insert remaining rows
            if (batchCount % 500 != 0) {
                insertStmt.executeBatch();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}