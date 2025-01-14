import java.lang.String;
import java.util.List;

public class EmployeeQueryExecutor {
    // Example of OQL query in a hypothetical Object Database API
    String oqlQuery = "SELECT FROM Employee WHERE department.name == 'IT'";

    Database database = new Database();
    List<Employee> itEmployees = database.executeQuery(oqlQuery);

    public static void main(String[] args) {
    }
}

class Database {
    public List<Employee> executeQuery(String query) {
        return null;
    }
}

class Employee {
}