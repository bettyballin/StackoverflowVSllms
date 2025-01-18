import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLExecutor {
    Connection connection;
    String query;

    public SQLExecutor() {
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "value"); // Sets '?' at index 1 to "value"
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}