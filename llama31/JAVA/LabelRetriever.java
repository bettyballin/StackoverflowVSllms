import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LabelRetriever {
    public static void main(String[] args) {
        // Assuming a JDBC connection
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT label FROM labels WHERE field_name = ?");
            pstmt.setString(1, "height");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String label = rs.getString(1);
                System.out.println(label);  // Output: Height (cm)
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}