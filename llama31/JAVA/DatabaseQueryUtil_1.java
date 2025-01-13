import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseQueryUtil_1_1 {
    public static void main(String[] args) throws SQLException {
        // Example for PostgreSQL using an array
        String[] values = {"A", "B", "C"};
        Connection connection = null; // Initialize connection object
        // Initialize connection here or pass it as an argument
        PreparedStatement pstmt = connection.prepareStatement("SELECT my_column FROM my_table WHERE search_column = ANY(?)");
        pstmt.setArray(1, connection.createArrayOf("VARCHAR", values));
    }
}