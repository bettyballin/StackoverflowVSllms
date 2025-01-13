import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector_14_14 {
    public static void main(String[] args) throws Exception {
        String requestUrl = "http://example.com"; // replaced request.getRequestURL().toString()
        String url = "jdbc:postgresql://localhost:5432/mydatabase?application_name=" + requestUrl;
        Connection conn = DriverManager.getConnection(url, "username", "password");
    }
}