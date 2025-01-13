import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

public class OracleOSAuth {
    public static void main(String[] args) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:/@localhost:1521:MYDBSID");
        ods.setNativeXA(true);
        ods.setDatabaseName("MYDBSID");

        Properties prop = new Properties();
        prop.setProperty("oracle.jdbc.authentication_services", "(NTS)");
        prop.setProperty("user", System.getProperty("user.name"));

        Connection conn = ods.getConnection(prop);
        System.out.println("Connected to Oracle using OS authentication");
    }
}