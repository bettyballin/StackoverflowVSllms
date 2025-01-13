import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.OracleDriver;

public class OracleOSAuth_1_1 {
    public static void main(String[] args) throws SQLException {
        OracleDriver driver = new OracleDriver();
        Properties prop = new Properties();
        prop.setProperty("user", System.getProperty("user.name"));
        prop.setProperty("oracle.jdbc.authentication_services", "(NTS)");
        Connection conn = driver.connect("jdbc:oracle:oci8:@", prop);
        System.out.println("Connected to Oracle using OS authentication");
    }
}