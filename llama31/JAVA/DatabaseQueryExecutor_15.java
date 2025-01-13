import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryExecutor_15_15 {
    public static void main(String[] args) {
        try {
            // assuming you have a Connection object named 'conn'
            Connection conn = DriverManager.getConnection("jdbc:sqlite:your_database.db");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM mytable WHERE mycolumn = ?");
            String userInput = "your_input"; // replace with your actual user input
            pstmt.setString(1, userInput); // set the parameter value
            ResultSet results = pstmt.executeQuery();
            while (results.next()) {
                // process the results
                System.out.println(results.getString(1)); // print the first column value
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}