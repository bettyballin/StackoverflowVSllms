import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    public static void main(String[] args) {
        DatabaseHelper helper = new DatabaseHelper();
        helper.getLastID();
    }

    public int getLastID() {
        int lastID = -1;
        try (Connection conn = DriverManager.getConnection("your_database_url", "your_username", "your_password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT @@IDENTITY AS ins_id")) {
            if (rs.next()) {
                lastID = rs.getInt("ins_id");
            }
        } catch (SQLException e) {
            // Handle the exception
        }
        return lastID;
    }
}