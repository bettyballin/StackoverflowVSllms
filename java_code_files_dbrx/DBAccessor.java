import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAccessor {

    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection conn;
    PreparedStatement statement;
    ResultSet resultSet;

    public DBAccessor() {
        try {
            conn = DriverManager.getConnection("jdbc:derby:MyDbTest; create=true; user=myusername; password=mypassword");
            statement = conn.prepareStatement(
                "SELECT ID, Name FROM Employee WHERE ID > ?",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}