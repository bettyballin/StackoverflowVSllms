import java.util.List;

public class CustomerDAO_1_1 {
    private SessionFactory sessionFactory;

    public List<Customer> getAllCustomers() {
        return sessionFactory.getCurrentSession()
            .createQuery("FROM Customer WHERE deleted = false", Customer.class)
            .getResultList();
    }

    public static void main(String[] args) {
    }
}