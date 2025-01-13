import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHelper_1_1 {

    public static void main(String[] args) {
        // Assuming you have a ResultSet object named rs
        ResultSet rs = null;
        try {
            // Your code to create a ResultSet object...
            // rs = statement.executeQuery("SELECT * FROM your_table");
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing ResultSet: " + e.getMessage());
        }
    }
}