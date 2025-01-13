import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector_13_13 {
    String url = "jdbc:postgresql://localhost:5432/mydatabase?application_name=my_java_app";
    Connection conn;

    public DatabaseConnector_13() throws Exception {
        conn = DriverManager.getConnection(url, "username", "password");
    }

    public static void main(String[] args) throws Exception {
        new DatabaseConnector_13();
    }
}