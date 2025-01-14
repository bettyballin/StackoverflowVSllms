public class ShutdownHookExample {
    // Example of adding a shutdown hook
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down resources...");
            // Cleanup code here
        }));
    }

    public static void main(String[] args) {
    }
}