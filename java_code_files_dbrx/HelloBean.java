import java.rmi.Remote;
import java.rmi.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the Stateless annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Stateless {
    String name() default "";
}

// Define the interface
interface HelloRemote extends Remote {
    String sayHello() throws Exception;
}

// Define the class
@Stateless(name = "Hello") // session bean
public class HelloBean implements HelloRemote {
    public HelloBean() {
    }

    // Implementation of RMI method declared in interface
    public String sayHello() throws Exception {
        return "Hello, world!";
    }
}