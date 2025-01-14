import java.lang.String;
import java.sql.*;

public class AutoCloseableConnection {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:...")) {
            // Use connection here
        } catch (SQLException e) {
            // Handle exception
        }
    }
}