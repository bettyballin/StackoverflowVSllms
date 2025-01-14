import java.sql.*;

public class SecureUserQuery {
    String sql = "SELECT * FROM users WHERE username = ?";
    PreparedStatement pstmt;
    ResultSet rs;

    public SecureUserQuery(Connection connection, String userInput) throws SQLException {
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, userInput);
        rs = pstmt.executeQuery();
    }

    public static void main(String[] args) throws Exception {
        Connection connection = null; // Initialize your connection here
        String userInput = ""; // Obtain user input here

        SecureUserQuery query = new SecureUserQuery(connection, userInput);

        // Process the ResultSet if needed
    }
}