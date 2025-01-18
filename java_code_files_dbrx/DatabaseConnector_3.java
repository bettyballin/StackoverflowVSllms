import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_3 {
    String url = "jdbc:sqlserver://localhost;databaseName=myDatabase;user=MyUserName;password=*****;";
    Properties props = new Properties();
    Connection conn;

    public DatabaseConnector_3() throws SQLException {
        props.setProperty("charSet", "SQL_Latin1_General_CP1_CI_AS");
        conn = DriverManager.getConnection(url, props);
    }

    public static void main(String[] args) {
    }
}