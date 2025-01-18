import java.lang.String;
public interface DataMapper {
    // Define the common methods used by all data mappers here, e.g., save(Object object) or findById(int id) etc.
}

// Implementation of the Data Mapper for a specific entity
class EmployeeDataMapper implements DataMapper {
    // Database-related operations go here, such as saving an employee to the database or retrieving an employee by ID.
}

public class Employee_3 {
    private final DataMapper mapper;

    public Employee_3(EmployeeDataMapper mapper) {   // Instead of directly using a concrete data mapper, use an interface or abstract class. This improves testability and maintains better separation between concerns.
        this.mapper = mapper;
    }

    public static void main(String[] args) {
    }
}