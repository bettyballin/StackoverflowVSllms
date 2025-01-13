import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_672 {
    public static void main(String[] args) {
        try {
            // Get a connection to the database
            String url = "your_database_url"; // replace with your database URL
            String username = "your_username"; // replace with your database username
            String password = "your_password"; // replace with your database password
            Connection conn = DriverManager.getConnection(url, username, password);

            // Get the database metadata
            DatabaseMetaData metaData = conn.getMetaData();

            // Get the list of tables
            ResultSet tables = metaData.getTables(null, null, null, new String[] {"TABLE"});

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                // Get the list of columns for each table
                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    System.out.println("  Column: " + columnName);
                }
            }

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}