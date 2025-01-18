import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeSalary {
    public static void main(String[] args) {
        // Replace these with your actual database URL, username, and password
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        float newSalaryValue = 50000.0f; // Example new salary
        int empID = 123; // Example employee ID

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String updateSQL = "UPDATE employees SET salary=? WHERE empid=?";

            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            // set the parameters
            pstmt.setFloat(1, newSalaryValue);
            pstmt.setInt(2, empID);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            // Close resources
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}