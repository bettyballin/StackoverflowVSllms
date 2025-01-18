import java.lang.String;

public class ShutdownHookThread_1 {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Code to stop your child processes goes here
        }));
    }

    public static void main(String[] args) {
    }
}