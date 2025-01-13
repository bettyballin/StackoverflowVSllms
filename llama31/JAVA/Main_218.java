import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_218 {
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            updateTableX(connection, "value1", "value2");
            updateTableY(connection, "value3", "value4");
            connection.commit();
        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Assuming you have these methods defined somewhere in your code
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
    }

    public static void updateTableX(Connection connection, String param1, String param2) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE table_x SET column1 = '" + param1 + "', column2 = '" + param2 + "'");
        }
    }

    public static void updateTableY(Connection connection, String param1, String param2) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE table_y SET column1 = '" + param1 + "', column2 = '" + param2 + "'");
        }
    }
}