import java.lang.String;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "txManager1")
public class MyService_27_27 {
    
    public void doSomethingInDatabase1() {
        // database operations
    }

	public static void main(String[] args) {
	}
}