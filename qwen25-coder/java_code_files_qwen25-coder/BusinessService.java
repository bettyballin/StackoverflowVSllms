public class BusinessService {
    private DAO dao;
    private TransactionManager transactionManager;

    public BusinessService(DAO dao, TransactionManager transactionManager) {
        this.dao = dao;
        this.transactionManager = transactionManager;
    }

    public void performBusinessOperation(DataObject data) {
        try {
            transactionManager.beginTransaction();
            // Perform operations using the DAO
            dao.save(data);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw new RuntimeException("Failed to perform business operation", e);
        }
    }

    public static void main(String[] args) {
        // Create instances for testing
        DAO dao = new DAO();
        TransactionManager transactionManager = new TransactionManager();
        BusinessService service = new BusinessService(dao, transactionManager);

        DataObject data = new DataObject();
        service.performBusinessOperation(data);
    }
}

// Placeholder class definitions
class DAO {
    public void save(DataObject data) {
        // Placeholder implementation
        System.out.println("Data saved.");
    }
}

class TransactionManager {
    public void beginTransaction() {
        // Placeholder implementation
        System.out.println("Transaction started.");
    }

    public void commitTransaction() {
        // Placeholder implementation
        System.out.println("Transaction committed.");
    }

    public void rollbackTransaction() {
        // Placeholder implementation
        System.out.println("Transaction rolled back.");
    }
}

class DataObject {
    // Placeholder class
}