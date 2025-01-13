import org.springframework.beans.factory.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class MyServiceClientConfig {
    // MyServiceClient.java
    @Bean
    public RmiProxyFactoryBean myServiceClient() {
        RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
        factory.setServiceUrl("rmi://localhost:1099/myService");
        factory.setServiceInterface(MyService.class);
        return factory;
    }

    public static void main(String[] args) {
    }
}