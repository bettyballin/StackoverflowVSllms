import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTransactionManager_1 {

    {
        Session session = null; // Initialize session appropriately
        Transaction tx = session.beginTransaction();
        tx.setIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
        try {
            // your DB operations go here..
        } catch (Exception e) {
            if (tx != null && !tx.wasRolledBack()) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        new HibernateTransactionManager_1();
    }
}