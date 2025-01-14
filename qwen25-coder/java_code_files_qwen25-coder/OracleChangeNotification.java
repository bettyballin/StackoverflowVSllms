import java.sql.*;
import java.util.Properties;
import oracle.jdbc.*;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class OracleChangeNotification {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:oracle:thin:@myhost:1521:orcl";
        String user = "username";
        String password = "password";

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Enable DCN
            OracleConnection oracleConnection = connection.unwrap(OracleConnection.class);
            Properties prop = new Properties();
            prop.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");

            // Register for database change notification
            DatabaseChangeRegistration dcr = oracleConnection.registerDatabaseChangeNotification(prop);

            // Add listener
            dcr.addListener(new DatabaseChangeListener() {
                @Override
                public void onDatabaseChangeNotification(DatabaseChangeEvent dce) {
                    System.out.println("Changes detected in the table!");
                    // Handle changes
                }
            });

            // Prepare the statement
            String sql = "SELECT * FROM my_table";
            Statement stmt = oracleConnection.createStatement();

            // Associate the statement with the registration
            ((OracleStatement)stmt).setDatabaseChangeRegistration(dcr);

            // Execute query and register for updates
            ResultSet rs = stmt.executeQuery(sql);

            // Keep application running to listen for notifications
            while (true) {
                Thread.sleep(1000); // Sleep so that application does not exit immediately
            }
        }
    }
}