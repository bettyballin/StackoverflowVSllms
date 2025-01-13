import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// RMI Service Interface
public interface MyService {
    String sayHello(String name);
}

// RMI Service Implementation
public class MyServiceImpl_5_5 implements MyService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

// RMI Client
public class MyClient {
    public static void main(String[] args) throws Exception {
        // Create an RMI registry
        LocateRegistry.createRegistry(1099);

        // Create a server stub
        MyServiceImpl_5 serviceImpl = new MyServiceImpl_5();
        Naming.rebind("rmi://localhost:1099/MyService", serviceImpl);

        // Create a client stub
        MyService service = (MyService) Naming.lookup("rmi://localhost:1099/MyService");

        // Call the remote method
        String response = service.sayHello("John");
        System.out.println(response);
    }
}