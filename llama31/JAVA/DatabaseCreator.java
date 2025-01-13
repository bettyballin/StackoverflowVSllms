import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:myDB;create=true");
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE SomeTable(id INTEGER IDENTITY, text LONGVARCHAR)");
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}