import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDAO {
    private HibernateTemplate hibernateTemplate;

    public void updateCustomer(Customer customer) {
        this.hibernateTemplate.update(customer);
    }

    public static void main(String[] args) {
        // You would typically create an instance of CustomerDAO and call updateCustomer here
    }
}