import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector_1 {
    String url = "jdbc:mysql://localhost/test"; //database URL, username and password
    String username = "root";
    String password = "";
    Connection conn;

    {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            conn = null;
        }
    }

    public static void main(String[] args) {
    }
}