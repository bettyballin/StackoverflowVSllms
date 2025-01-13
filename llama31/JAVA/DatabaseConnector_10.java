import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnector_10_10 {
    String url = "jdbc:oracle:thin:@//localhost:1521/ORCL?oracle.jdbc.defaultNChar=true&oracle.jdbc.charset=ISO-8859-5";
    Properties props = new Properties();

    public DatabaseConnector_10() throws Exception {
        Connection conn = DriverManager.getConnection(url, props);
    }

    public static void main(String[] args) throws Exception {
        new DatabaseConnector_10();
    }
}