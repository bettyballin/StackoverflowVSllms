import oracle.jdbc.OracleConnection;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import java.sql.DriverManager;

public class Main_581 {
    public static void main(String[] args) throws Exception {
        // Create a connection to the database
        OracleConnection conn = (OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

        // Create a database change listener
        DatabaseChangeListener listener = new MyDatabaseChangeListener();

        // Register the listener with the connection
        conn.registerDatabaseChangeListener(listener);
    }
}

class MyDatabaseChangeListener implements DatabaseChangeListener {
    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent databaseChangeEvent) {
        // Handle database change event
    }
}