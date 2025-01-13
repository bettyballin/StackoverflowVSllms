import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryExecutor_1_1 {
    public static void executeNonQuery(String queryString, Object... params) {
        try (Connection conn = getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(queryString)) {
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            // handle exception
            System.err.println("Error executing query: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        // implement your connection creation logic here
        // for example:
        // return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        throw new SQLException("Connection creation logic not implemented");
    }

    public static void main(String[] args) {
        // example usage:
        // executeNonQuery("INSERT INTO mytable (name, age) VALUES (?, ?)", "John Doe", 30);
    }
}