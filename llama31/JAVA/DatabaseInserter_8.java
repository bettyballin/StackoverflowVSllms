import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInserter_8_8 {
    public static void main(String[] args) {
        String SQL = "INSERT INTO table (ID, VALUE) values (?, encrypt_clob(?))";
        Connection connection = null; // initialize your database connection here
        try (PreparedStatement ps = connection.prepareStatement(SQL)) {
            int id = 0; // replace with your id value
            String plaintext = ""; // replace with your plaintext value
            ps.setInt(1, id);
            ps.setString(2, plaintext);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}