import java.sql.*;

public class DatabaseUtil {

    public static int reserveWork(Connection conn, int batchId, int workSize, int contentTypeId) throws SQLException {
        String sql = "BEGIN ? := pkg_your_package.reserveWork(?, ?, ?); END;";
        
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.registerOutParameter(1, Types.NUMBER);
            stmt.setInt(2, batchId);
            stmt.setInt(3, workSize);
            stmt.setInt(4, contentTypeId);
            
            stmt.execute();
            
            return stmt.getInt(1);
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "user", "password")) {
            conn.setAutoCommit(false); // Start transaction
            
            int rowsReserved = reserveWork(conn, 1, 10, 1);
            System.out.println(rowsReserved + " rows reserved.");
            
            // Handle commit/rollback based on your business logic
            conn.commit();
        } catch (SQLException e) {
            System.err.println("Error in reserving work: " + e.getMessage());
            e.printStackTrace();
        }
    }
}