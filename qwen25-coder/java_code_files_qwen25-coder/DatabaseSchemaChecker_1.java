import java.lang.String;
import java.sql.*;

public class DatabaseSchemaChecker_1 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=your_database";
        String user = "your_user";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData md = conn.getMetaData();
            
            // Check tables
            ResultSet rsTables = md.getTables(null, null, "%", new String[]{"TABLE"});
            while (rsTables.next()) {
                System.out.println("Table: " + rsTables.getString(3));
                
                // Check columns for each table
                ResultSet rsColumns = md.getColumns(null, null, rsTables.getString(3), "%");
                while (rsColumns.next()) {
                    System.out.println("\tColumn: " + rsColumns.getString(4) + ", Type: " + rsColumns.getInt(5));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}