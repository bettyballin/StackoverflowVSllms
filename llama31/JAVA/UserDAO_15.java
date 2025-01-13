import java.sql.PreparedStatement;
import java.sql.Connection;

public class UserDAO_15_15 {
    public static void main(String[] args) {
        // You need to establish a connection to a database first
        // This example assumes that you have a Connection object named conn
        Connection conn = null;
        // Initialize conn here...

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            String userInput = ""; // Initialize userInput here...
            pstmt.setString(1, userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}