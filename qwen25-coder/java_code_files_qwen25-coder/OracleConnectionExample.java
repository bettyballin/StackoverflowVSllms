import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionExample {
    // Example of connecting with SQL developer (conceptual)
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port:sid", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}