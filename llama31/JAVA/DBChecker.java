import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBChecker {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb"; // replace with your DB URL
        String username = "myuser"; // replace with your DB username
        String password = "mypassword"; // replace with your DB password

        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            if (conn != null) {
                System.out.println("Database exists and connection is successful!");
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Database does not exist or connection failed: " + e.getMessage());
        }
    }
}