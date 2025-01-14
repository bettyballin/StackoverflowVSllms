public class UpdateManager {
    public void update(Object transientObject) throws DatabaseException {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            // Use saveOrUpdate to handle both persist and merge cases
            s.saveOrUpdate(transientObject);
            s.flush();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new DatabaseException("Cannot update object", e);
        }
    }

    public static void main(String[] args) {
    }
}

class DatabaseException extends Exception {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

class HibernateException extends Exception {
    public HibernateException(String message) {
        super(message);
    }
}

class HibernateUtil {
    public static Session getSession() {
        // Return a mock Session object
        return new Session();
    }
}

class Session {
    public Transaction beginTransaction() {
        return new Transaction();
    }

    public void saveOrUpdate(Object obj) {
        // Save or update the object
    }

    public void flush() {
        // Flush the session
    }
}

class Transaction {
    public void commit() {
        // Commit the transaction
    }

    public void rollback() {
        // Rollback the transaction
    }
}