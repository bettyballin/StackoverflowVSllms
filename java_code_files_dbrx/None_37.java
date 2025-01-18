import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class None_37 {

    public static void main(String[] args) {
        try {
            // Establish a database connection (replace with actual database URL, username, and password)
            Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");

            // Create a mock request
            MockRequest request = new MockRequest();

            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO test VALUES (ID, ?, ?)");
            pStmt.setString(1, request.getParameter("sender"));
            pStmt.setString(2, StringEscapeUtils.escapeHtml4(request.getParameter("text"))); // Escaping with Apache Commons Lang library
            pStmt.executeUpdate();

            pStmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Mock HttpServletRequest to simulate request parameters
class MockRequest {
    public String getParameter(String name) {
        // Return test values for parameters
        if ("sender".equals(name)) {
            return "test_sender";
        } else if ("text".equals(name)) {
            return "test_text";
        }
        return "";
    }
}

// Dummy StringEscapeUtils class
class StringEscapeUtils {
    public static String escapeHtml4(String input) {
        // For demonstration, return the input as is
        return input;
    }
}