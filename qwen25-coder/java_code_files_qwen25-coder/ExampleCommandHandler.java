public class ExampleCommandHandler extends AbstractHandler {
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Code to perform action
        System.out.println("Executing example command");
        return null;
    }
}

abstract class AbstractHandler {
    public abstract Object execute(ExecutionEvent event) throws ExecutionException;
}

class ExecutionEvent {
    // Empty implementation
}

class ExecutionException extends Exception {
    public ExecutionException() {
        super();
    }
    public ExecutionException(String message) {
        super(message);
    }
}