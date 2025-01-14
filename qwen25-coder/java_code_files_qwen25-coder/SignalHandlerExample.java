import java.lang.String;
public class SignalHandlerExample {
    public static void main(String[] args) {
        // Register a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook is running!");
            // Perform cleanup or other shutdown tasks here
        }));

        // Simulate long-running process
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                break;
            }
        }
    }
}