import java.sql.*;
import java.time.LocalDate;

public class Main_571 {
    public static void main(String[] args) {
        // Initialize variables
        LocalDate date = LocalDate.now(); // Use today's date as an example
        Connection conn = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            String dbUrl = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database URL
            String username = "your_username"; // Replace with your database username
            String password = "your_password"; // Replace with your database password
            conn = DriverManager.getConnection(dbUrl, username, password);

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);

            // Store the date in MySQL
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO mytable (date) VALUES (?)");
            stmt.setDate(1, sqlDate);
            stmt.executeUpdate();

            System.out.println("Date inserted into the database successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            // Close the connection if it's not null
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close the database connection: " + e.getMessage());
                }
            }
        }
    }
}