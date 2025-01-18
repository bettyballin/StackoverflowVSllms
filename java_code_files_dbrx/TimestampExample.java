import oracle.sql.TIMESTAMPTZ;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TimestampExample {
    public static void main(String[] args) {
        try {
            // Obtain database connection
            Connection conn = getConnection();

            // Assume tsTz comes from your database query results
            TIMESTAMPTZ tsTz = getTIMESTAMPTZFromDatabase(conn);

            // Convert TIMESTAMPTZ to Timestamp
            Timestamp ts = new Timestamp(tsTz.getJavaDate(conn).getTime());

            System.out.println("Timestamp: " + ts);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TIMESTAMPTZ getTIMESTAMPTZFromDatabase(Connection conn) throws SQLException {
        // Simulate retrieving TIMESTAMPTZ from the database
        // In actual code, you would retrieve this from a ResultSet
        String tzString = "2023-10-17 10:15:30 America/New_York";
        return TIMESTAMPTZ.toTIMESTAMPTZ(conn, tzString);
    }

    private static Connection getConnection() throws SQLException {
        // Replace with your actual database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "your_username";
        String password = "your_password";

        return DriverManager.getConnection(url, username, password);
    }
}