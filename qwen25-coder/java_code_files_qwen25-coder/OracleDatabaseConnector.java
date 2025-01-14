import java.lang.String;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDatabaseConnector {
    String url = "jdbc:oracle:thin:@localhost:1521:yourDB";
    Properties props = new Properties();
    Connection conn;

    {
        props.setProperty("user", "yourUser");
        props.setProperty("password", "yourPassword");
        props.setProperty("useUnicode", "true");
        props.setProperty("characterEncoding", "UTF-8");

        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}