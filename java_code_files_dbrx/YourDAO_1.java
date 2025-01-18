public class YourDAO_1 {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional // This method will have automatic transaction management using Hibernate
    public void performDatabaseActions() {
        // Perform database actions, Spring takes care of creating and handling transactions.
    }

    public static void main(String[] args) {
    }
}

interface SessionFactory {}

@interface Autowired {}

@interface Transactional {}