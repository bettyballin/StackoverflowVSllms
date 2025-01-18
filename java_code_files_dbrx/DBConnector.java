import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    String url = "jdbc:mysql://localhost:3306/your_database"; //Replace with your Database and Port details
    String dbUserName ="YourUsername";  //Replace 'YourUsername' with actual username.
    String dbPassword = "YourPASSWORD";  //Replace 'YourPASSWORD' with actual password.
    Connection conn = null;

    public DBConnector() {
        try {
            conn = DriverManager.getConnection(url, dbUserName, dbPassword);
        } catch (SQLException ex) { /** handle exception, i.e., print the stack trace **/ }
    }

    public static void main(String[] args) {
    }
}