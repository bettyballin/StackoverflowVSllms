import java.lang.String;

public class HandlerExample {
    abstract class Handler {
        private Handler successor;

        public void setSuccessor(Handler successor) { this.successor = successor; }

        public Object handleRequest(Request request) {
            if (canHandle(request)) {
                return process(request);
            } else if (successor != null) {
                return successor.handleRequest(request);
            }
            return null;
        }

        protected abstract boolean canHandle(Request request);
        protected abstract Object process(Request request);
    }

    class Handler1 extends Handler {
        @Override
        protected boolean canHandle(Request request) { return request instanceof Type1; }
        @Override
        protected Object process(Request request) { /* doSomething1 */ return new Result(); }
    }

    public static void main(String[] args) {
        // Example usage
    }
}

// Placeholder classes to make the code compile
class Request { }
class Type1 extends Request { }
class Result { }