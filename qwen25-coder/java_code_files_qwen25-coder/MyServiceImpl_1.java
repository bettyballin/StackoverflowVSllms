import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RemoteServiceRelativePath {
    String value();
}

// Define the interface
interface RemoteService {
}

// Define the servlet class
class RemoteServiceServlet {
}

@RemoteServiceRelativePath("myService")
interface MyService extends RemoteService {
    String refreshServer(int refreshCount);
}

public class MyServiceImpl_1 extends RemoteServiceServlet implements MyService {

    @Override
    public String refreshServer(int refreshCount) {
        // Process the refresh count as needed
        return "Refresh count received: " + refreshCount;
    }

    public static void main(String[] args) {
    }
}