import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_206 {
    public static void main(String[] args) {
        // Acquire lock on table
        Connection conn = null; // get connection from JNDI
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("LOCK TABLE MYTABLE IN EXCLUSIVE MODE");

            // Perform updates

            // Release lock
            stmt.execute("COMMIT");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}