import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecureQueryConstructor {

    public SecureQueryConstructor(String username, Connection connection) throws SQLException {

        String query = "SELECT * FROM users WHERE 1=1";

        if (username != null) {
            query += " AND username = ?";
        }

        PreparedStatement pstmt = connection.prepareStatement(query);

        if (username != null) {
            pstmt.setString(1, username);
        }

        // Proceed to execute the query if needed

    }

    public static void main(String[] args) throws SQLException {
        String username = null; // Or retrieve from args or input
        Connection connection = null; // Assign a real connection

        new SecureQueryConstructor(username, connection);
    }

}