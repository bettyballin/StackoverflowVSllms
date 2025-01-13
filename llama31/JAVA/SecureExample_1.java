import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Example of secure Java code that doesn't require bytecode analysis
public class SecureExample_1_1 {
    public static void main(String[] args) {
        // Use prepared statements to prevent SQL injection
        String query = "SELECT * FROM users WHERE name = ?";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, "JohnDoe");
        ResultSet results = pstmt.executeQuery();
    }
}