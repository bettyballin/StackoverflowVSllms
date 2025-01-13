import java.sql.*;

public class DatabaseResultSetProcessor_1_1 {
    public static void main(String[] args) {
        // Define the database connection URL, username, and password
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            // Create a Statement object to execute the query
            String query = "SELECT * FROM table_name";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process each row individually
            while (rs.next()) {
                String column1 = rs.getString(1);
                String column2 = rs.getString(2);
                String column3 = rs.getString(3);
                // ...
                System.out.println("Column1: " + column1 + ", Column2: " + column2 + ", Column3: " + column3);
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while processing the database result set: " + e.getMessage());
        }
    }
}