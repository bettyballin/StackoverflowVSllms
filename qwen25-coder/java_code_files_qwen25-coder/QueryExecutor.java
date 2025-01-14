import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {
    public static void main(String[] args) {
        String sql;
        Object x = null; // Declare x
        String y = "someValue"; // Declare y
        Connection connection = null; // Assume we have a connection object

        if (x != null) {
            sql = "SELECT z WHERE x > y";
        } else {
            sql = "SELECT z WHERE x <= y";
        }
        sql += " JOIN a ON b";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set parameters for the PreparedStatement if necessary
            // preparedStatement.setObject(1, someValue);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Process your result set here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}