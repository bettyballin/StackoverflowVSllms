import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService_13_13 {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void performDatabaseActions() {
        // Perform database actions using sessionFactory.getCurrentSession()
    }

    public static void main(String[] args) {
    }
}