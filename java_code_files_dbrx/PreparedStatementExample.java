import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String javaVariable = "some_value";
        try (Connection conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM YourTableName WHERE Column1 <= ?")) {
            stmt.setString(1, javaVariable);
            // You may want to execute the query here, e.g., ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {}
    }
}