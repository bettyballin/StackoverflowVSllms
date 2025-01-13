import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class SQLInjectionValidator {
    public void validateInput(HttpServletRequest request) {
        // Validate user input to prevent SQL injection
        String userInput = request.getParameter("username");
        if (userInput != null && !userInput.isEmpty()) {
            // Use prepared statements to prevent SQL injection
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
                pstmt.setString(1, userInput);
                ResultSet results = pstmt.executeQuery();
                // ...
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SQLInjectionValidator validator = new SQLInjectionValidator();
        // For demonstration purposes, assume HttpServletRequest is available
        // HttpServletRequest request = ...
        // validator.validateInput(request);
    }
}