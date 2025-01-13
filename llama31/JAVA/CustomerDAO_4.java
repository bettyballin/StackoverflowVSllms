import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.Session;

public class CustomerDAO_4_4 {
    private Session session;

    public List<Customer> getCustomers(DetachedCriteria criteria) {
        // Ensure to validate 'criteria' to prevent potential security issues
        return criteria.getExecutableCriteria(session).list();
    }

    public static void main(String[] args) {
    }
}