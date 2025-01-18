import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbcURL"; // Replace with actual JDBC URL
        String username = "username"; // Replace with actual username
        String password = "password"; // Replace with actual password
        String query1 = "SELECT * FROM table1"; // Replace with actual query1
        String query2 = "SELECT * FROM table2 WHERE column = ?"; // Replace with actual query2

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt1 = conn.createStatement();
             ResultSet rs1 = stmt1.executeQuery(query1);
             PreparedStatement pstmt2 = conn.prepareStatement(query2)) { // or call to .createStatement() for non-parameterized query

            while (rs1.next()) {
                // process results from ResultSet rs1;
                // ...

                try (ResultSet rs2 = pstmt2.executeQuery()) {
                    while (rs2.next()) {
                        // Process with rs2 here and close rs2 when done.
                        // ...
                    }
                } catch (SQLException sqle) {
                    System.out.println("Error occurred in nested loop for ResultSet 'rs2'");
                    sqle.printStackTrace();
                }
            }
        } catch (SQLException e1) {
            // Handle error related to conn, stmt or rs here...
            e1.printStackTrace();
        }
    }
}