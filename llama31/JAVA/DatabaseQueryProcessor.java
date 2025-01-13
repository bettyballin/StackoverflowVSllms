import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DatabaseQueryProcessor {
    public static void main(String[] args) {
        // Define database connection properties
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        // Create a connection to the database
        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            String query = "SELECT * FROM table_name";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                RowSetFactory factory = RowSetProvider.newFactory();
                try (CachedRowSet crs = factory.createCachedRowSet()) {
                    crs.populate(rs);

                    while (crs.next()) {
                        // Process each row individually
                        String column1 = crs.getString(1);
                        String column2 = crs.getString(2);
                        String column3 = crs.getString(3);
                        // ...
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }
}