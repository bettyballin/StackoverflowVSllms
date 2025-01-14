import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        String sql = "{call testEM(?)}";
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, "yourIdValue");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}