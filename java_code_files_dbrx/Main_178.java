import java.sql.*;
import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        String mySearchQuery = "SELECT whatever FROM questions WHERE views * ? + votes * ? > answers AND NOT(answered) ORDER BY view";
        int N = 0; // N from user input properly parsed as Int to prevent SQL injection
        int M = 0; // M from user input properly parsed as Int too...
        
        DataSource dataSource = null; // Assume dataSource is initialized elsewhere

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(mySearchQuery)) {
            ps.setInt(1, N);
            ps.setInt(2, M);
            try (ResultSet rs = ps.executeQuery()) {
                // .... handle result ...
            }
        } catch (SQLException e) {
            // .... Exception handling code ....
        }
    }
}