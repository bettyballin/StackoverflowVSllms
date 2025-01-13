// MyService.java
public interface MyService {
    void doSomething();
}

// MyServiceImpl.java
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl_2 implements MyService {
    @Override
    public void doSomething() {
        // implementation
    }
}

// MyServiceExporter.java
import org.springframework.beans.factory.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class MyServiceExporter {
    @Bean
    public RmiServiceExporter myServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("myService");
        exporter.setServiceInterface(MyService.class);
        exporter.setService(new MyServiceImpl());
        return exporter;
    }

    public static void main(String[] args) {
    }
}