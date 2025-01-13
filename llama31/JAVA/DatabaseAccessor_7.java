import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAccessor_7_7 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("url", "username", "password");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SCOTT.EMPLOYEES");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}