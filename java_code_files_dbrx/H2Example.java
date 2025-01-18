import org.h2.jdbcx.JdbcDataSource;
import java.util.UUID;
import java.sql.*;

public class H2Example {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcDataSource ds = new JdbcDataSource();  // Define the DataSource (H2 Memory DB)
        ds.setURL("jdbc:h2:mem:" + UUID.randomUUID());  // URL points to a unique in-memory database instance
        ds.setUser("dba");
        ds.setPassword("");

        try (Connection conn = ds.getConnection()) {
            Class.forName(conn.getMetaData().getDriverName(), true, conn.getClass().getClassLoader());  // Needed for some JDBC Drivers
            Statement stat = conn.createStatement();
            ResultSet rs;

            try {
                rs = stat.executeQuery("SELECT * FROM my_table");    // This will throw SQLException if query syntax is not correct
            } catch (SQLException ex) {
                System.out.println(ex);  // do something with the exception such as logging or reraising in a runtimeexception
            }
        }
    }
}