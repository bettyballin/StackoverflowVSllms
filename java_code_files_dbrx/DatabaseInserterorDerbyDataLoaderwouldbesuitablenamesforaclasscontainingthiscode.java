import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class DatabaseInserterorDerbyDataLoaderwouldbesuitablenamesforaclasscontainingthiscode {

    public static void main(String[] args) {

        Connection conn = null; // Declare conn before try block

        try {
            // Load the Derby driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Create a connection to the database
            String URL = "jdbc:derby://localhost:1527/myDB";
            String dbUser = "user";
            String dbPassword = "password";
            conn = DriverManager.getConnection(URL, dbUser, dbPassword);

            Vector<String> strings = new Vector<>();
            // Fill this vector with your values..

            PreparedStatement prepStmt;
            for (String s : strings) {
                // Assume you have a table called MYTABLE and two columns C1 and C2...
                String insertSQL = "insert into MyTable(C1,C2) values(?, ?)";
                prepStmt = conn.prepareStatement(insertSQL);
                prepStmt.setString(1, s);
                // Set your other value here in case you have two columns..
                prepStmt.setString(2, "otherValue"); // Set the second parameter
                prepStmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex);
            }
        }
    }
}