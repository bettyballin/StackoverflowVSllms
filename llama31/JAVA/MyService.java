import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Service layer
@Service
public class MyService {
    @Autowired
    private MyDao myDao;

    @Transactional
    public void doBusinessLogic() {
        myDao.doSomething();
        myDao.doSomethingElse();
    }

    public static void main(String[] args) {
        MyService myService = new MyService();
        myService.doBusinessLogic();
    }
}

import org.springframework.stereotype.Repository;

// DAO layer
@Repository
class MyDao {
    // No @Transactional annotation here
    public void doSomething() {
        // Data access logic
        System.out.println("Doing something");
    }

    public void doSomethingElse() {
        // More data access logic
        System.out.println("Doing something else");
    }
}