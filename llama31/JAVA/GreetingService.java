import java.lang.String;

public class GreetingService {
    @RemoteServiceRelativePath("greet")
    public interface GreetingService extends RemoteService {
        //...
    }

    public static void main(String[] args) {
    }
}