import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseExample_1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myDatabase";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String userInput = "very nice;) DROP TABLE FOO;";
            
            // Use a PreparedStatement to safely include user input in your SQL query
            String sql = "INSERT INTO myTable (columnName) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, userInput);  // This sets the first parameter of the prepared statement
                
                pstmt.executeUpdate();  // Execute the update operation
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}