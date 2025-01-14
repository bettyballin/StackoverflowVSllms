import java.util.List;

public class PersonDAO {
    // Existing method
    public Person getPersonById(int id) {
        // Implementation goes here
        return null;
    }

    // New methods for lazy loading
    public List<Address> loadAddressesForPerson(Person person) { 
        // Call stored procedure or query that returns addresses related to the given person ID.
        return null;
    }
}

class Person {
    // Person class definition
}

class Address {
    // Address class definition
}