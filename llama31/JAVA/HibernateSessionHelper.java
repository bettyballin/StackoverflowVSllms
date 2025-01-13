import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSessionHelper {
    private SessionFactory sessionFactory;

    public HibernateSessionHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void enableActiveOpsFilter() {
        Session session = sessionFactory.getCurrentSession();
        session.enableFilter("activeOps");
    }

    public static void main(String[] args) {
        // You need to create a Hibernate SessionFactory instance and pass it to the helper
        // For demonstration purposes, let's assume you have a HibernateUtil class that creates a SessionFactory
        // SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // HibernateSessionHelper helper = new HibernateSessionHelper(sessionFactory);
        // helper.enableActiveOpsFilter();
    }
}