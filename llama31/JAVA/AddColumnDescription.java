import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddColumnDescription {
    public static void main(String[] args) {
        // Establish a connection to the database
        String url = "jdbc:sqlserver://your_server:1433;databaseName=your_database";
        String user = "your_username";
        String password = "your_password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return;
        }

        // Create a statement object
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error creating statement: " + e.getMessage());
            return;
        }

        // Define the table and column names
        String tableName = "your_table_name";
        String columnName = "your_column_name";
        String description = "This is a description of the column";

        // Call the sp_addextendedproperty stored procedure
        String query = "EXEC sp_addextendedproperty @name=N'MS_Description', @value=N'" + description + "', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'" + tableName + "', @level2type=N'COLUMN', @level2name=N'" + columnName + "'";
        try {
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println("Error adding column description: " + e.getMessage());
        }

        // Clean up
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}