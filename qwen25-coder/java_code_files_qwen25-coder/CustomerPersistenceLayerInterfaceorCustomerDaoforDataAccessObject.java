import java.util.List;
import java.util.Optional;

public class CustomerPersistenceLayerInterfaceorCustomerDaoforDataAccessObject {

    public interface CustomerRepository {
        List<Customer> findAllCustomers(); // SELECT *
        Optional<Customer> findCustomerById(Long id); // SELECT by ID
        void add(Customer customer); // INSERT or UPDATE
        void remove(Customer customer); // DELETE
    }

    public static void main(String[] args) {
    }
}

class Customer {
    // Minimal implementation to make the code executable
}