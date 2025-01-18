import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DbConnectionManager {

    public static void main(String[] args) {
        DataSource myDataSource = getDataSource(); // get your DataSource here
        String query = "SELECT * FROM myTable";

        Connection conn = null;

        try {
            conn = myDataSource.getConnection(); // get your Connection here from DataSource (pool)

            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    // Do something with result set data
                }
            } catch (SQLException e ) {
                System.out.print("Error: " + e);
            } finally  {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e1) {
                        System.out.println("Error closing Statement: " + e1);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.print("Error: " + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // return connection back to pool
                } catch (SQLException e2) {
                    System.out.println("Error closing Connection: " + e2);
                }
            }
        }
    }

    private static DataSource getDataSource() {
        // Implement method to get DataSource
        return null; // Placeholder
    }
}