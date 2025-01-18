import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerRepository {
    private EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    public void fetchCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomers", Customer.class);
        List<Customer> customers = query.getResultList(); // get all customers from database
        // You can add code here to process the customers list
    }

    public static void main(String[] args) {
        // Create an instance of EntityManager (requires a real implementation in a real scenario)
        EntityManager em = null; // Placeholder for the actual EntityManager instance
        CustomerRepository repository = new CustomerRepository(em);
        repository.fetchCustomers();
    }
}

class Customer {
    // Customer class implementation
}