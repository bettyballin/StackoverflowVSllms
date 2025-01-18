import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class SessionManager {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory(); // Initialize this once, at the beginning of your application

    public static void performOperation(TransactionalOperation operation) throws Exception {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Perform your data access/manipulation operations here using the provided `operation` instance
                operation.perform(session);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null && !transaction.wasCommitted()) {
                    transaction.rollback();
                }

                throw new Exception("Failed to perform operation: " + operation, e);
            } finally {
                session.close(); // Close the session once your work is done
            }
        }
    }

    private static SessionFactory buildSessionFactory() {
        File configFile = new File("hibernate.cfg.xml"); // Assign reference to Hibernate configuration file here
        Configuration configuration = new Configuration().configure(configFile);
        return configuration.buildSessionFactory();
    }
}

// Define the TransactionalOperation interface
interface TransactionalOperation {
    void perform(Session session) throws Exception;
}

// Minimal class definitions to make the code executable with `javac`
class Configuration {
    public Configuration configure(File file) {
        return this;
    }

    public SessionFactory buildSessionFactory() {
        return new SessionFactory();
    }
}

class SessionFactory {
    public Session openSession() {
        return new Session();
    }
}

class Session implements AutoCloseable {
    public Transaction beginTransaction() {
        return new Transaction();
    }

    @Override
    public void close() {
        // Close the session
    }
}

class Transaction {
    private boolean committed = false;

    public void commit() {
        committed = true;
    }

    public boolean wasCommitted() {
        return committed;
    }

    public void rollback() {
        // Roll back the transaction
    }
}