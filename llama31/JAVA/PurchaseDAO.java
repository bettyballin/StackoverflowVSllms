import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDAO {
    public static void main(String[] args) {
        // Database connection settings
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";
        int productid = 1; // Replace with your product ID

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO purchases (productid, price) VALUES (?, (SELECT price FROM products WHERE id = ?))");
            pstmt.setInt(1, productid);
            pstmt.setInt(2, productid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}