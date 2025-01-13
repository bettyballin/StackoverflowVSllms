import java.lang.Runtime;

public class ShutdownHookThread {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // Cleanup code here
            }
        });
    }
}