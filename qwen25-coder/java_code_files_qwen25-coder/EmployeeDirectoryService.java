import java.util.HashMap;
import java.util.Map;
// Example of a simple Employee Directory Service API in Java

public class EmployeeDirectoryService {
    private Map<String, String> employeeDirectory;

    public EmployeeDirectoryService() {
        this.employeeDirectory = new HashMap<>();
        populateDirectory();
    }

    private void populateDirectory() {
        // Simulated data population
        employeeDirectory.put("12345", "John Doe - john.doe@example.com");
        employeeDirectory.put("67890", "Jane Smith - jane.smith@example.com");
    }

    public String getEmployeeInfo(String id) {
        return employeeDirectory.getOrDefault(id, "Employee not found.");
    }

    public static void main(String[] args) {
    }
}