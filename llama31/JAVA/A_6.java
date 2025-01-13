import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A_6_6 {
    Connection conn = null;

    public A_6(String URL, String username, String password) throws SQLException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            conn = DriverManager.getConnection(URL, username, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            invalidate();
        }
    }

    public void invalidate() {
        // You need to implement this method or remove the call to it
    }

    public static void main(String[] args) {
        // You need to create an instance of A_6 to use it
        try {
            A_6 a = new A_6("jdbc:derby:mydatabase;create=true", "myuser", "mypassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}