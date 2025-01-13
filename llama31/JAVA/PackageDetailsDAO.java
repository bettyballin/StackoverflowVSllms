import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDetailsDAO {
    public static void main(String[] args) {
        String query = "SELECT pd.id, s1.state_name AS sender_state, s2.state_name AS receiver_state "
                + "FROM Package_Details pd "
                + "JOIN States s1 ON pd.sender_state = s1.state_id "
                + "JOIN States s2 ON pd.receiver_state = s2.state_id";

        try (Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password")) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet results = pstmt.executeQuery();

            // You can process the results here
            while (results.next()) {
                System.out.println(results.getString("id") + ", " + results.getString("sender_state") + ", " + results.getString("receiver_state"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}