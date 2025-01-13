import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyService_14_14 {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void performDatabaseActions() {
        // Perform database actions using sessionFactory.getCurrentSession()
    }

	public static void main(String[] args) {
	}
}