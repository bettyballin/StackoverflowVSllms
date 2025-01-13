import java.sql.*;

public class DatabaseAccessor {
    public int getLastID() {
        try (Connection conn = getDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY AS ins_id")) {

            if (rs.next()) {
                return rs.getInt("ins_id");
            } else {
                throw new SQLException("No ID found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getDatabase() {
        // This method should return a Connection object to your database
        // For example:
        try {
            return DriverManager.getConnection("jdbc:sqlserver://your_host:your_port;databaseName=your_database", "your_username", "your_password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DatabaseAccessor accessor = new DatabaseAccessor();
        int lastID = accessor.getLastID();
        System.out.println("Last ID: " + lastID);
    }
}