import java.lang.String;

// RMIClient.java
import javax.naming.InitialContext;
import javax.naming.NamingException;

// Define the RemoteInterface
interface RemoteInterface {
    void myMethod();
}

public class RMIClient {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            RemoteInterface remote = (RemoteInterface) ctx.lookup("SessionBean#RemoteInterface");
            remote.myMethod();
        } catch (NamingException e) {
            // Handle exception
            System.out.println("NamingException caught: " + e.getMessage());
        }
    }
}