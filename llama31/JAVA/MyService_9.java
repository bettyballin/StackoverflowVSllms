import java.lang.String;
import java.lang.annotation.Annotation;

// Define the XsrfProtect annotation
@Retention(RetentionPolicy.RUNTIME)
@interface XsrfProtect {
}

// Define the RemoteService interface
interface RemoteService {
}

public class MyService_9_9 {
    @XsrfProtect
    public interface MyService extends RemoteService {
        // ...
    }

    public static void main(String[] args) {
    }
}