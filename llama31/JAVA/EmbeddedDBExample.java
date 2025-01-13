import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmbeddedDBExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the embedded database driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Create a connection to the database
            conn = DriverManager.getConnection("jdbc:derby:mydatabase;create=true");

            // Create a table to store the strings
            String createTableSQL = "CREATE TABLE mytable (id INT PRIMARY KEY, mystring VARCHAR(255))";
            PreparedStatement pstmt = conn.prepareStatement(createTableSQL);
            pstmt.execute();

            // Insert a string into the table
            String insertSQL = "INSERT INTO mytable (id, mystring) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Hello, World!");
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}