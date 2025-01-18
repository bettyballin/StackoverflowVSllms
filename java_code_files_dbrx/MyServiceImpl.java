public class MyServiceImpl implements MyService {
    private final SomeDao someDao;
    private final OtherDao otherDao;
    private final TransactionManager transactionManager;

    public MyServiceImpl(SomeDao someDao, OtherDao otherDao, TransactionManager transactionManager) {
        this.someDao = someDao;
        this.otherDao = otherDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public void myBusinessOperation() throws BusinessException {
        try {
            transactionManager.begin();

            // Perform operations across multiple DAOs, if needed...
            someDao.doSomething();
            otherDao.doSomeOtherThing();

            transactionManager.commit();
        } catch (RuntimeException e) {
            transactionManager.rollback();
            throw new BusinessException(e);
        }
    }

    public static void main(String[] args) {
        SomeDao someDao = new SomeDaoImpl();
        OtherDao otherDao = new OtherDaoImpl();
        TransactionManager transactionManager = new TransactionManagerImpl();

        MyServiceImpl service = new MyServiceImpl(someDao, otherDao, transactionManager);

        try {
            service.myBusinessOperation();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}

// Define MyService interface
interface MyService {
    void myBusinessOperation() throws BusinessException;
}

// Define SomeDao interface and an implementation
interface SomeDao {
    void doSomething();
}

class SomeDaoImpl implements SomeDao {
    public void doSomething() {
        System.out.println("SomeDaoImpl: doing something");
    }
}

// Define OtherDao interface and an implementation
interface OtherDao {
    void doSomeOtherThing();
}

class OtherDaoImpl implements OtherDao {
    public void doSomeOtherThing() {
        System.out.println("OtherDaoImpl: doing some other thing");
    }
}

// Define TransactionManager interface and an implementation
interface TransactionManager {
    void begin();
    void commit();
    void rollback();
}

class TransactionManagerImpl implements TransactionManager {
    public void begin() {
        System.out.println("TransactionManager: begin");
    }
    public void commit() {
        System.out.println("TransactionManager: commit");
    }
    public void rollback() {
        System.out.println("TransactionManager: rollback");
    }
}

// Define BusinessException class
class BusinessException extends Exception {
    public BusinessException(Exception e) {
        super(e);
    }
}