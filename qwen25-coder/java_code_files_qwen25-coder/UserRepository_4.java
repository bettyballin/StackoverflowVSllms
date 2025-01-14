import java.lang.String;
// Assuming you have a User entity and a SessionFactory setup
public class UserRepository_4 {
    private final SessionFactory sessionFactory;

    public UserRepository_4(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Create
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Read
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(User.class, id);
        } finally {
            session.close();
        }
    }

    // Update
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Delete
    public void deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
    }
}

// Dummy classes to allow compilation

class SessionFactory {
    public Session openSession() {
        return new Session();
    }
}

class Session {
    public Transaction beginTransaction() {
        return new Transaction();
    }
    public void save(User user) {}
    public void update(User user) {}
    public void delete(User user) {}
    public User get(Class<User> cls, Long id) { return new User(); }
    public void close() {}
}

class Transaction {
    public void commit() {}
    public void rollback() {}
}

class User {}