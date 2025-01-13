import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_422 {

    public static void main(String[] args) {
        String dbUrl = "your_database_url"; // e.g., "jdbc:oracle:thin:@localhost:1521:ORCL"
        String username = "your_username";
        String password = "your_password";

        Connection conn = null;
        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            conn = DriverManager.getConnection(dbUrl, username, password);

            // Get the next sequence value
            String query = "SELECT my_seq.nextval FROM dual";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) { // Move to the first row if it exists
                int nextId = rs.getInt(1);

                // Insert a new row with the generated ID
                String insertQuery = "INSERT INTO my_table (id, /* other columns */) VALUES (?, /* other values */)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setInt(1, nextId);
                // ... set other parameters
                pstmt.executeUpdate();

                System.out.println("Inserted successfully with ID: " + nextId);
            } else {
                System.out.println("Failed to retrieve the next sequence value.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close the database connection.");
                }
            }
        }
    }
}