import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_5 {
    public static String sanitize(String input) {
        input = input.trim();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password")) {
            return conn.prepareStatement("SELECT ?").setString(1, input).getParameterMetaData().getParameterTypeName(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(sanitize("your_input"));
    }
}