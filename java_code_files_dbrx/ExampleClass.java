import javax.persistence.*;

public class ExampleClass {

    public void exampleQuery() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = null;
        try {
            // Begin a new transaction
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Your EclipseLink query logic here...

            // If everything goes fine, commit the transaction:
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // An error occurred - rollback the database operation and re-throw the exception
                transaction.rollback();
            }
            throw e; // Re-throw the exception
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();
        example.exampleQuery();
    }
}