import java.lang.String;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTransactionManager implements TransactionManager {
    private Session session;
    private Transaction transaction;

    public HibernateTransactionManager(Session session) {
        this.session = session;
    }

    @Override
    public void beginTransaction() {
        if (transaction == null || !transaction.isActive()) {
            transaction = session.beginTransaction();
        }
    }

    @Override
    public void commitTransaction() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
    }
}