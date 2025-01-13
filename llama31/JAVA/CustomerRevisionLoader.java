import java.util.List;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.SessionFactory;

public class CustomerRevisionLoader {
    public static void main(String[] args) {
        SessionFactory sessionFactory = // initialize sessionFactory here
        AuditReader auditReader = AuditReaderFactory.get(sessionFactory.getCurrentSession());
        List<Customer> revisions = auditReader.createQuery()
            .forRevisionsOfEntity(Customer.class, false, true)
            .getResultList();
    }
}