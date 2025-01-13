import java.sql.*;

public class DatabaseInserter_7_7 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:your_database_url", "your_username", "your_password");

        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO mytable (name) VALUES ('John Doe')";
        int rowsAffected = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            long id = generatedKeys.getLong(1);
            // Use the generated id
            System.out.println("Generated ID: " + id);
        }

        conn.close();
    }
}