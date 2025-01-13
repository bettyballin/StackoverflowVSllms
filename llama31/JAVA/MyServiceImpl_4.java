// MyService.java
public interface MyService {
    String doSomething();
}

// MyServiceImpl.java
public class MyServiceImpl_4 implements MyService {
    @Override
    public String doSomething() {
        // Do something
        return "Result";
    }
}

// MyController.java
public class MyController {
    private MyService myService;
    
    public MyController(MyService myService) {
        this.myService = myService;
    }
    
    public String doSomething() {
        return myService.doSomething();
    }
}

// RmiConfig.java
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RmiConfig {
    public RmiProxyFactoryBean myService() {
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl("rmi://localhost:1099/myService");
        factoryBean.setServiceInterface(MyService.class);
        return factoryBean;
    }
}