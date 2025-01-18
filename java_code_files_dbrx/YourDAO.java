import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

public class YourDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void performDatabaseActions() {
        // Perform database actions, Spring takes care of transactions.
    }
}