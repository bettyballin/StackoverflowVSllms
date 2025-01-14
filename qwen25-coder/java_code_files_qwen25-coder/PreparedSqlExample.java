import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSqlExample {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost/employees";
    private static final String USER = "username";
    private static final String PASS = "password";
    
    // Example of using prepared statements in Java to prevent SQL Injection
    public void updateEmployeeSalary(int employeeId, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, employeeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    }
}