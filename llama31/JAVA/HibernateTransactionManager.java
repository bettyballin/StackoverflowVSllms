import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTransactionManager implements TransactionManager {
    private SessionFactory sessionFactory;

    public HibernateTransactionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void beginTransaction() {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        sessionFactory.getCurrentSession().getTransaction().rollback();
    }

    public static void main(String[] args) {
    }
}

interface TransactionManager {
    void beginTransaction();
    void commitTransaction();
    void rollbackTransaction();
}