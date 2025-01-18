import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;

public class Main {
    private SessionFactory yourSessionFactory; // Assume this is initialized elsewhere

    private static final Logger log = Logger.getLogger(Main.class);

    public void method() throws Throwable {
        Session session = null;
        Transaction tx = null;
        try {
            session = yourSessionFactory.getCurrentSession(); // Or open a new one here, depending on what you configured in Spring/Hibernate
            if (session != null) {
                tx = session.beginTransaction();

                // Your database methods calls: humanDao.update(he);
                // brauncDao.update(be); etc.

                tx.commit(); // Commit the transaction at end of method, after all statements.
            }
        } catch (Throwable ex) {
            log.error("Error in method", ex);
            if (tx != null) tx.rollback();
            throw ex;
        } finally {
            if (session != null) session.close(); // Always close your Session at end to free connections
        }
    }
    
    public static void main(String[] args) throws Throwable {
        Main main = new Main();
        main.method();
    }
}