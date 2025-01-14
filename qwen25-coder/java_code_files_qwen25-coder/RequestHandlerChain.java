import java.util.ArrayList;
import java.util.List;

class Request {}
class Type1 extends Request {}
class Result {}
class CouldNotParseRequestException extends RuntimeException {}

abstract class Handler {
    public abstract Object handleRequest(Request request);
}

class Handler1 extends Handler {
    @Override
    public Object handleRequest(Request request) {
        if (request instanceof Type1) { /* doSomething1 */ return new Result(); }
        return null;
    }
}

public class RequestHandlerChain {
    private final List<Handler> handlers = new ArrayList<>();

    public RequestHandlerChain() {
        handlers.add(new Handler1());
        // Add other handlers
    }

    public Object handleRequest(Request request) {
        for (Handler handler : handlers) {
            Object result = handler.handleRequest(request);
            if (result != null) return result;
        }
        throw new CouldNotParseRequestException();
    }

    public static void main(String[] args) {
    }
}