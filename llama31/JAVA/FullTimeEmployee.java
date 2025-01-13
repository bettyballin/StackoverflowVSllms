import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// Hibernate example: Single Table Inheritance
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Employee {
    // Add any common attributes and methods for Employee here
}

@Entity
public class FullTimeEmployee extends Employee {
    // Add specific attributes and methods for FullTimeEmployee here

    public static void main(String[] args) {
        // You can instantiate FullTimeEmployee or perform other operations here
        FullTimeEmployee fte = new FullTimeEmployee();
        // Perform operations with fte
    }
}