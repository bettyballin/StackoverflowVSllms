import org.hsqldb.jdbc.JDBCDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new JDBCDriver());
        return DriverManager.getConnection("jdbc:hsqldb:file:/tmp/testdb", "SA", "");
    }

    public static void main(String[] args) {
        TestConnection tc = new TestConnection();
        try {
            Connection con = tc.createConnection();
            if (con != null) {
                System.out.println("Connection established.");
            } else {
                System.out.println("Failed to make connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}