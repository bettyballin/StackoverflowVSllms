import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseQueryHelper_2_2 {
    public static void main(String[] args) {
        // Assuming you have a database connection established
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String lastName = "your_last_name";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = con.prepareStatement("select * from table1 where last_name like ?");
            ps.setString(1, "%" + lastName + "%");
            // You would typically execute the query and process the results here
            // ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}