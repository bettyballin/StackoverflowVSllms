import java.lang.String;

interface FaultBarrier {
    static void handleFault(RunnableWithException r) {
        try {
            r.run();
        } catch (Exception e) {
            // Handle the exception
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    @FunctionalInterface
    interface RunnableWithException {
        void run() throws Exception;
    }
}

public class FaultHandler {
    public static void main(String[] args) {
        FaultBarrier.handleFault(() -> {
            // Code that might throw ConstraintViolationException
            throw new Exception("Test exception");
        });
    }
}