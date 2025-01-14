import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    public interface CustomerDao {
        List<Customer> findAll(); // SELECT *
        Optional<Customer> findById(Long id); // SELECT by ID
        void save(Customer customer); // INSERT or UPDATE
        void deleteById(Long id); // DELETE
    }

    public static void main(String[] args) {
    }

}