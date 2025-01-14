import java.sql.*;

public class DatabaseDataTransfer {
    public static void main(String[] args) throws SQLException {
        Connection srcConn = DriverManager.getConnection("jdbc:oracle:thin:@//sourceDB", "username", "password");
        Connection destConn = DriverManager.getConnection("jdbc:oracle:thin:@//destDB", "username", "password");

        String selectSql = "SELECT c1, c5, c6 FROM SRC_Table";
        PreparedStatement selectStmt = srcConn.prepareStatement(selectSql);
        ResultSet rs = selectStmt.executeQuery();

        String insertSql = "INSERT INTO DEST_Table (col1, col2, col3) VALUES (?, ?, ?)";
        PreparedStatement insertStmt = destConn.prepareStatement(insertSql);

        int batchSize = 1000;
        int count = 0;

        while (rs.next()) {
            insertStmt.setInt(1, rs.getInt("c1"));
            insertStmt.setInt(2, rs.getInt("c5"));
            insertStmt.setInt(3, rs.getInt("c6"));
            insertStmt.addBatch();

            if (++count % batchSize == 0) {
                insertStmt.executeBatch();
            }
        }
        // Execute remaining batch
        insertStmt.executeBatch();

        selectStmt.close();
        rs.close();
        insertStmt.close();
        srcConn.close();
        destConn.close();
    }
}