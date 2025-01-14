import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class AddColumnDescription {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://your_server_address;databaseName=your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Adding a description to column1
            String sql = "{call sp_addextendedproperty (?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, "MS_Description");
                stmt.setString(2, "This is the description for column1.");
                stmt.setString(3, "SCHEMA");
                stmt.setString(4, "dbo");  // Change 'dbo' to your schema if needed
                stmt.setString(5, "TABLE");
                stmt.setString(6, "table_name");
                stmt.setString(7, "COLUMN");
                stmt.setString(8, "column1");
                stmt.execute();
            }

            // Adding a description to column2
            sql = "{call sp_addextendedproperty (?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, "MS_Description");
                stmt.setString(2, "This is the description for column2.");
                stmt.setString(3, "SCHEMA");
                stmt.setString(4, "dbo");  // Change 'dbo' to your schema if needed
                stmt.setString(5, "TABLE");
                stmt.setString(6, "table_name");
                stmt.setString(7, "COLUMN");
                stmt.setString(8, "column2");
                stmt.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}