import org.hibernate.SessionFactory;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

// Simple BusinessLayer class for demonstration
public class BusinessLayer {
    private final TransactionTemplate transactionTemplate;

    public BusinessLayer(TransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public void doSomeBusinessLogic() {
        // Example of doing something within a transaction
        transactionTemplate.execute(transactionStatus -> {
            // Perform database operations here
            System.out.println("Doing some business logic within a transaction...");
            return null; // Return something meaningful if needed
        });
    }
}

public class Application {
    public static void main(String[] args) {
        // Initialize Hibernate SessionFactory
        // For demonstration purposes, let's assume a basic configuration.
        // In a real application, you would likely use a more sophisticated configuration method.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        TransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        BusinessLayer businessLayer = new BusinessLayer(transactionManager);
        businessLayer.doSomeBusinessLogic();
    }
}

// Helper class to get a SessionFactory
public class HibernateUtil {
    static SessionFactory getSessionFactory() {
        // Here you should implement the actual logic to create and return a SessionFactory
        // This can involve reading a hibernate.cfg.xml file, using Spring's configuration, annotations, or programmatically configuring it.
        // For simplicity, let's assume a very basic, hypothetical implementation:
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}