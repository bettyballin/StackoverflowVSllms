import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String query = "CREATE TABLE attribute (" +
                    "name VARCHAR(50) PRIMARY KEY, " +
                    "value_type VARCHAR(10), " +
                    "str_value VARCHAR(100), " +
                    "int_value INT, " +
                    "dec_value DECIMAL)";

            stmt.executeUpdate(query);
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}