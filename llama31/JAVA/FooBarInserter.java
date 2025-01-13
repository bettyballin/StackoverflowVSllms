import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FooBarInserter {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("url", "user", "password");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO bar (foo_id) VALUES ((SELECT id FROM foo WHERE name = ?))");
            pstmt.setString(1, "Andrey");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}