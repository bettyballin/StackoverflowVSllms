import java.lang.String;

// Define the required exceptions
class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

class HibernateException extends RuntimeException {
    public HibernateException(String message) {
        super(message);
    }
}

// Define interface for SessionFactory
interface SessionFactory {
    Session getCurrentSession();
}

// Define interface for Session
interface Session extends AutoCloseable {
    Transaction getTransaction();
    void beginTransaction();
    Object merge(Object object);
    void flush();
    @Override
    void close();
}

// Define interface for Transaction
interface Transaction {
    boolean isActive();
    void commit();
}

// Define Configuration class
class Configuration {
    public Configuration configure() {
        return this;
    }

    public SessionFactory buildSessionFactory() {
        return new SessionFactory() {
            @Override
            public Session getCurrentSession() {
                return new Session() {
                    @Override
                    public Transaction getTransaction() {
                        return new Transaction() {
                            @Override
                            public boolean isActive() {
                                return false;
                            }

                            @Override
                            public void commit() {
                            }
                        };
                    }

                    @Override
                    public void beginTransaction() {
                    }

                    @Override
                    public Object merge(Object object) {
                        return object;
                    }

                    @Override
                    public void flush() {
                    }

                    @Override
                    public void close() {
                    }
                };
            }
        };
    }
}

public class HibernateDAO<T> {
    // Always use the same Factory in your whole application
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    // For each request to DB, create a new session
    public T update(T transientObject) throws DatabaseException {
        try (Session s = factory.getCurrentSession()) {  // 'try-with-resources' will automatically close the Session after you’re done with your operations.
            if (!s.getTransaction().isActive())
                s.beginTransaction();

            T mergedObject = (T) s.merge(transientObject);
            s.flush();  // Commit changes immediately to avoid conflicts with other transactions trying to update same object in their own Sessions
            s.getTransaction().commit();

            return mergedObject;
        } catch (HibernateException e) {
            System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
            throw new DatabaseException("Cannot update object");
       }
    }

    public static void main(String[] args) {
        // Example usage
        HibernateDAO<String> dao = new HibernateDAO<>();
        try {
            dao.update("Test");
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}