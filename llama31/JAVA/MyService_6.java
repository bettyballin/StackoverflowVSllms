import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Use @Component for Spring-managed beans
@Component
public class MyService_6_6 {
    @Autowired
    private MyRepository repository;
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

// Use @Configurable for classes created outside of Spring's control
@Configurable
public class MyEntity {
    @Autowired
    private MyService service;

    public static void main(String[] args) {
    }
}