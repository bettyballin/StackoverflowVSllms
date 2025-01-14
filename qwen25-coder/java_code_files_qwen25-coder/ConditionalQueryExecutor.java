import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConditionalQueryExecutor {

    static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    static final String USER = "yourusername";
    static final String PASS = "yourpassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Execute the first query and fetch result
            ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
            int custCount = 0;
            if (rs1.next()) {
                custCount = rs1.getInt(1);
            }

            // Conditionally execute the second query based on the first query's result
            if (custCount > 10) {
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM PRODUCT");
                while (rs2.next()) {
                    // Process each row from the product table
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}