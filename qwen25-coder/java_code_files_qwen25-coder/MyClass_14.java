import java.sql.SQLIntegrityConstraintViolationException;

public class MyClass {

    // Define DataIntegrityViolationException
    static class DataIntegrityViolationException extends RuntimeException {
        public DataIntegrityViolationException(String message, Throwable cause) {
            super(message, cause);
        }

        public DataIntegrityViolationException(String message) {
            super(message);
        }
    }

    // Define the EntityManager interface
    interface EntityManager {
        void persist(Object entity) throws DataIntegrityViolationException;
    }

    // Implement a dummy EntityManager
    class MyEntityManager implements EntityManager {
        public void persist(Object entity) throws DataIntegrityViolationException {
            // Simulate an exception
            throw new DataIntegrityViolationException(
                "Integrity violation",
                new SQLIntegrityConstraintViolationException("Duplicate entry", "23000", 1062)
            );
        }
    }

    // Define the User class
    static class User {
        // User properties
    }

    // Define entityManager
    private EntityManager entityManager;

    public MyClass() {
        this.entityManager = new MyEntityManager();
    }

    public void insertUser(User user) {
        try {
            entityManager.persist(user);
        } catch (DataIntegrityViolationException e) {
            Throwable cause = e.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException sqlIcve =
                    (SQLIntegrityConstraintViolationException) cause;
                System.err.println("Message: " + sqlIcve.getMessage());
                System.err.println("SQLState: " + sqlIcve.getSQLState());
                System.err.println("ErrorCode: " + sqlIcve.getErrorCode());
            } else {
                // Handle other types of SQLExceptions or nested causes
                e.printStackTrace();
            }
        }
    }

    // Optional main method to test the code
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        User user = new User();
        myClass.insertUser(user);
    }
}