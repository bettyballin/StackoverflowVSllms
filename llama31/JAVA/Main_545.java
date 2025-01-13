import java.sql.Connection;
import javax.sql.DataSource;
import org.jboss.resource.adapter.jdbc.WrappedConnection;

public class Main_545 {
    public static void main(String[] args) throws Exception {
        // Assuming dataSource is already defined and initialized
        DataSource dataSource = new org.jboss.resource.adapter.jdbc.WrappedDataSource(); // Initialize dataSource here

        // Get the wrapped connection
        Connection wrappedConn = dataSource.getConnection();
        WrappedConnection wrappedConnection = (WrappedConnection) wrappedConn;

        // Unwrap the connection
        Connection oracleConn = wrappedConnection.getUnderlyingConnection();

        // Now you can use the oracleConn as an oracle.jdbc.OracleConnection
        System.out.println("Oracle Connection: " + oracleConn);
    }
}