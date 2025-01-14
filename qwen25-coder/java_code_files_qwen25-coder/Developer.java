import java.util.List;

public class Main {
    // Example: Building an organization with departments and sub-departments
    interface Employee {}
    class Developer implements Employee{}
    class Department implements Employee{
        List<Employee> employees; // Can contain Developers or other Departments
    }
    
    public static void main(String[] args) {
    }
}