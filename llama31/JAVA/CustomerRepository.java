import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CustomerRepository {
    private Session session;

    public CustomerRepository(Session session) {
        this.session = session;
    }

    public List<Customer> getCustomersWithArticles() {
        List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
        for (Customer customer : customers) {
            Hibernate.initialize(customer.getArticles());
        }
        return customers;
    }

    public static void main(String[] args) {
        // You need to create a Hibernate session and pass it to the CustomerRepository
        // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Session session = sessionFactory.getCurrentSession();
        // CustomerRepository customerRepository = new CustomerRepository(session);
        // customerRepository.getCustomersWithArticles();
    }
}