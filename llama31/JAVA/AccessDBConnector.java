import java.sql.*;

public class AccessDBConnector {
    public static void main(String[] args) {
        // Load the JDBC-ODBC bridge driver
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e.getMessage());
            return;
        }

        // Set up the connection URL
        String dbUrl = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=\\\\path\\to\\your\\database.mdb";

        // Connect to the database
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            System.out.println("Connected to the database!");

            // Create a statement and execute a query
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM your_table")) {

                // Process the results
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}