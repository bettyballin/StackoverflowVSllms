import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_824 {
    private Connection conn;
    private CallableStatement stmt;
    private ResultSet rset;

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    public void execute() {
        try {
            // Initialize the database connection
            String dbUrl = "jdbc:postgresql://localhost:5432/mydatabase";
            String username = "myuser";
            String password = "mypassword";
            conn = DriverManager.getConnection(dbUrl, username, password);

            // Prepare and execute the stored procedure call
            stmt = conn.prepareCall("SELECT * FROM end_spool()");
            rset = stmt.executeQuery();

            // Process the result set
            while (rset.next()) {
                // Handle the results here
                System.out.println(rset.getString(1)); // Replace with your logic
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}