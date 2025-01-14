import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryHandler {
    // Example: Java code snippet for database interaction with JDBC

    public static void main(String[] args) {
        String sql = "SELECT column1, column2, column3, column4, column5 FROM my_table WHERE id = ?";

        Connection connection = null; // Obtain your connection here

        int someId = 1; // Example ID value

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, someId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("column1"));
                    // process other necessary fields
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}