import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SqliteBatchInsert {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlite:path_to_your_database.db";
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = null;

        try {
            conn.setAutoCommit(false); // Start batch mode
            String sql = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < 65536; i++) { // Example loop
                pstmt.setString(1, "value" + i);
                pstmt.setInt(2, i);
                pstmt.addBatch();

                if (i % 32768 == 0) { // Execute batch
                    pstmt.executeBatch();
                    conn.commit(); // Commit current batch
                }
            }

            // Execute leftover updates
            pstmt.executeBatch();
            conn.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
}