import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCodePrinter {
    public static void main(String[] args) {
        // Assuming resultSet is a valid ResultSet object
        ResultSet resultSet = null; // Initialize resultSet
        try {
            String code = resultSet.getString("code");
            System.out.println(code);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}