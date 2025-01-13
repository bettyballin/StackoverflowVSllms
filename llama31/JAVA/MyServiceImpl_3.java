import java.lang.String;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

// MyServiceImpl.java
@Service
public class MyServiceImpl_3_3 implements MyService {
    @Override
    @Secured("ROLE_USER")
    public void doSomething() {
        // implementation
    }

    public static void main(String[] args) {
    }
}

interface MyService {
    void doSomething();
}