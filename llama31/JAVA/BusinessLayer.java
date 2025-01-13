// TransactionManager.java
public interface TransactionManager {
    void beginTransaction();
    void commitTransaction();
    void rollbackTransaction();
}

// TransactionManagerImpl.java
public class TransactionManagerImpl implements TransactionManager {
    @Override
    public void beginTransaction() {
        System.out.println("Transaction begun");
    }

    @Override
    public void commitTransaction() {
        System.out.println("Transaction committed");
    }

    @Override
    public void rollbackTransaction() {
        System.out.println("Transaction rolled back");
    }
}

// BusinessLayer.java
public class BusinessLayer {
    private TransactionManager transactionManager;

    public BusinessLayer(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void doSomeBusinessLogic() {
        transactionManager.beginTransaction();
        try {
            // Call DAO methods here
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            throw e;
        }
    }

    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionManagerImpl();
        BusinessLayer businessLayer = new BusinessLayer(transactionManager);
        businessLayer.doSomeBusinessLogic();
    }
}