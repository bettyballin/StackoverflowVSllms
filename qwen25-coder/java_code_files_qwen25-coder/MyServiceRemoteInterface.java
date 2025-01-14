import java.lang.String;
import javax.ejb.Remote;

public class MyServiceRemoteInterface {
    @Remote
    public interface MyServiceRemote {
        String sayHello();
        // Add other methods here
    }

    public static void main(String[] args) {
    }
}