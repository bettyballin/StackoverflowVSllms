import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CityBlockDAO {

    public static void main(String[] args) {
        // Create a SessionFactory from hibernate.cfg.xml
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session sess = factory.openSession();
        Transaction tx = sess.beginTransaction();

        // Enable your custom filter
        Filter filter = sess.enableFilter("operationFilter");
        filter.setParameter("state", "incomplete"); // Set your filter parameter here

        CityBlock cb = (CityBlock) sess.get(CityBlock.class, 1);
        tx.commit();
        sess.close();
    }
}

class CityBlock {
    // CityBlock class implementation
}