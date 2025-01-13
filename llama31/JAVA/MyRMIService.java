import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless // Changed from @Service for standard Java EE compliance
public class MyRMIService {
    @EJB
    private MyRemoteImpl myRemoteImpl;

    public String sayHello() {
        return myRemoteImpl.sayHello();
    }

    public static void main(String[] args) {
        // This main method will not actually test the EJB as EJBs are meant to be run within a Java EE container.
        // For testing, consider using an embedded container like OpenEJB or deploying to a server.
    }
}