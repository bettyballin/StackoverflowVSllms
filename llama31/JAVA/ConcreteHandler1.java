// Define the Request class
class Request {
    // Add properties and methods as needed
}

public abstract class Handler {
    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract Object handleRequest(Request request);

    protected void passToNext(Request request) {
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler1 extends Handler {
    @Override
    public Object handleRequest(Request request) {
        // Handle request or pass to next handler
        if (true) { // some condition
            return "Result from ConcreteHandler1"; // some result
        } else {
            passToNext(request);
            return null;
        }
    }
}

class ConcreteHandler2 extends Handler {
    @Override
    public Object handleRequest(Request request) {
        // Handle request or pass to next handler
        if (true) { // some condition
            return "Result from ConcreteHandler2"; // some result
        } else {
            passToNext(request);
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Handler chain = new ConcreteHandler1();
        chain.setSuccessor(new ConcreteHandler2());
        Object result = chain.handleRequest(new Request());
        System.out.println(result);
    }
}