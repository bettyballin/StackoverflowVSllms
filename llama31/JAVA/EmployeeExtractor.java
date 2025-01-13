import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class EmployeeExtractor {
    public static void main(String[] args) {
        // Assume 'resultSet' is a ResultSet object containing all rows
        ResultSet resultSet = null; // Initialize resultSet
        try {
            Set<String> uniqueEmployees = new HashSet<>();
            while (resultSet.next()) {
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                uniqueEmployees.add(employeeId + ":" + name);
            }
        } catch (SQLException e) {
            // Handle the exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}