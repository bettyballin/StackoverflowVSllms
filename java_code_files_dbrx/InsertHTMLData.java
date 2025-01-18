import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertHTMLData {
    public static void main(String[] args) throws Exception {
        String sql = "INSERT INTO HTMLStore(htmlData) VALUES(?)"; // Using ? as placeholder for value in query
        
        // Initialize your database connection (conn) here
        Connection conn = null; // Replace with actual connection initialization
        
        // Prepare the SQL statement
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        // Your sanitized HTML content
        String sanitizedHTML = "<p>Your sanitized HTML content</p>";
        
        // Replace the ? with the sanitized string
        pstmt.setString(1, sanitizedHTML);
        
        // Optionally execute the statement
        // pstmt.executeUpdate();
    }
}