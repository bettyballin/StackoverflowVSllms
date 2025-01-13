import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccessor_1_1 {
    int lastID;

    public DatabaseAccessor_1() {
        try {
            Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY AS ins_id");
            if (rs.next()) {
                lastID = rs.getInt("ins_id");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseAccessor_1 accessor = new DatabaseAccessor_1();
    }
}