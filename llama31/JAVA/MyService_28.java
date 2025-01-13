import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService_28_28 {
    
    @Transactional(value = "txManager1")
    public void doSomethingInDatabase1() {
        // database operations
    }
    
    @Transactional(value = "txManager2")
    public void doSomethingInDatabase2() {
        // database operations
    }

	public static void main(String[] args) {
	}
}