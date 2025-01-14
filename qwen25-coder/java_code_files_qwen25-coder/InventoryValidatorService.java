import java.lang.String;

public class InventoryValidatorService {

    // Instance variables
    private EmployeeService employeeService;
    private InventoryRepository inventoryRepository;

    // Constructor
    public InventoryValidatorService() {
        this.employeeService = new EmployeeService();
        this.inventoryRepository = new InventoryRepository();
    }

    // Example service method that checks referential integrity
    public void updateInventoryWithEmployeeCheck(int employeeId, Inventory inventory) {
        // First, check if the employee exists in the employees database
        boolean isEmployeeValid = employeeService.isEmployeeIdValid(employeeId);

        if (!isEmployeeValid) {
            throw new IllegalArgumentException("Employee ID does not exist: " + employeeId);
        }

        // If valid, proceed with updating the inventory
        inventoryRepository.updateInventory(inventory);
    }

    public static void main(String[] args) {
        // Example usage
        InventoryValidatorService service = new InventoryValidatorService();
        Inventory inventory = new Inventory();
        service.updateInventoryWithEmployeeCheck(123, inventory);
    }
}

// Employee Service class
class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    // Method to validate the employee ID
    public boolean isEmployeeIdValid(int employeeId) {
        // Implementation would involve querying the employees database
        return employeeRepository.existsById(employeeId);
    }
}

// Inventory Repository class
class InventoryRepository {
    public void updateInventory(Inventory inventory) {
        // Dummy implementation
        System.out.println("Inventory updated.");
    }
}

// Employee Repository class
class EmployeeRepository {
    public boolean existsById(int employeeId) {
        // For simplicity, assume all employee IDs less than 1000 exist
        return employeeId < 1000;
    }
}

// Inventory class
class Inventory {
    // Inventory fields and methods
}