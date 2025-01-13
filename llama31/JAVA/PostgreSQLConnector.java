import java.util.Properties;

import org.postgresql.PGConnection;
import org.postgresql.util.PGProperty;

public class PostgreSQLConnector {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty(PGProperty.APPLICATION_NAME.getName(), "my_java_app");
        PGConnection conn = new PGConnection(props);
    }
}