import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    
    @Autowired
    private MyDomainObjectRepository repository;
    
    @Override
    public void doSomething(MyDomainObject domainObject) {
        // perform operations on the domain object
    }
    
    public void doSomething(Long domainObjectId) {
        MyDomainObject domainObject = repository.findById(domainObjectId).orElseThrow();
        doSomething(domainObject);
    }

    public static void main(String[] args) {
    }
}