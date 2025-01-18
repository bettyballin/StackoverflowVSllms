import java.util.Properties;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleConnection;

public class OracleConnectionProperties {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        // Other properties here...
        props.setProperty("user", "myUserName");
        props.setProperty("password", "myPassword");
        // Set application information
        props.setProperty(OracleConnection.CLIENT_IDENTIFIER, "my program");
        props.setProperty(OracleConnection.CLIENT_INFO, "something");
        props.setProperty(OracleConnection.MODULE, "my module");
        props.setProperty(OracleConnection.ACTION, "my action");
        // Create connection with specified properties
        OracleDriver ora = new OracleDriver();
        java.sql.Connection conn = ora.connect("jdbc:oracle:thin:@localhost:1521/ORCL", props);
    }
}