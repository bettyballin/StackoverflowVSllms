import java.util.Arrays;
import java.util.List;

// Define the Request class
class Request {
    // Add properties and methods as needed
}

public interface Handler {
    Object handleRequest(Request request);
}

class ConcreteHandler1 implements Handler {
    @Override
    public Object handleRequest(Request request) {
        // Handle request or return null
        if (true) {
            return "some result";
        } else {
            return null;
        }
    }
}

class ConcreteHandler2 implements Handler {
    @Override
    public Object handleRequest(Request request) {
        // Handle request or return null
        if (false) {
            return "some result";
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Handler> handlers = Arrays.asList(new ConcreteHandler1(), new ConcreteHandler2());
        for (Handler handler : handlers) {
            Object result = handler.handleRequest(new Request());
            if (result != null) {
                System.out.println(result);
                break;
            }
        }
    }
}