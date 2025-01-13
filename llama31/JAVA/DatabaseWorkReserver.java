import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWorkReserver {
    public static void main(String[] args) {
        // Assuming you have a database connection set up
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            DatabaseWorkReserver dbr = new DatabaseWorkReserver(conn);
            dbr.reserveWork(1, 10, 1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Connection conn;

    public DatabaseWorkReserver(Connection conn) {
        this.conn = conn;
    }

    public void reserveWork(int batchId, int workSize, int contentType) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("BEGIN reserveWork(?,?,?); END;")) {
            pstmt.setInt(1, batchId);
            pstmt.setInt(2, workSize);
            pstmt.setInt(3, contentType);
            pstmt.setFetchSize(workSize);
            pstmt.execute();
        }
    }
}