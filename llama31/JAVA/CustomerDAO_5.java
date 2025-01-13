import java.util.List;

public class CustomerDAO_5_5 {
    // Assuming session is a valid Hibernate Session object
    private Session session;

    public List<Customer> getCustomersWithPreload(String[] preloadFields) {
        List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
        for (Customer customer : customers) {
            for (String field : preloadFields) {
                // Initialize based on field, e.g., using Hibernate.initialize()
                // This would require a more complex implementation to handle various field types
            }
        }
        return customers;
    }

    public static void main(String[] args) {
        // Create an instance of CustomerDAO_5 to use its methods
        CustomerDAO_5 dao = new CustomerDAO_5();
        // You would need to set up the session and configure Hibernate properly
        // For demonstration purposes, this is omitted
    }
}