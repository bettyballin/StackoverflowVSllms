import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlServerConnector {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlserver://localhost;databaseName=your_db;integratedSecurity=true";
        Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM your_table");

        while (rs.next()) {
            // Do something with the results
        }
    }
}