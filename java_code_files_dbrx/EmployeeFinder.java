import java.util.Optional;
import java.util.List;
import java.util.Arrays;

public class EmployeeFinder {

    public static void main(String[] args) {
        EmployeeFinder finder = new EmployeeFinder();
        Optional<Employee> employee = finder.findPerson();
        if (employee.isPresent()) {
            System.out.println("Found employee: " + employee.get().getName());
        } else {
            System.out.println("Employee not found");
        }
    }

    private Optional<Employee> findPerson() {
        return getPersons().stream()
            .filter(person -> "John".equals(person.getName()))
            .findFirst(); // return Optional.empty if not found or optional of Employee instance otherwise.
    }

    private List<Employee> getPersons() {
        return Arrays.asList(
            new Employee("John"),
            new Employee("Jane"),
            new Employee("Bob")
        );
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}