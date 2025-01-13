import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryExecutor_9_9 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("url", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM table1")) {

            while (rs.next()) {
                // Do something with the data from the first ResultSet

                try (ResultSet rs2 = stmt.executeQuery("SELECT * FROM table2")) {
                    while (rs2.next()) {
                        // Do something with the data from the second ResultSet
                    }
                }
            }
        } catch (SQLException e) {
            // Handle the exception
        }
    }
}