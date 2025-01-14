import java.lang.String;
public class ForkSimulation {
    public static void main(String[] args) {
        Runnable task = () -> {
            // Your program execution logic here
            System.out.println("Running in thread: " + Thread.currentThread().getName());
        };

        // Create and start the first thread
        Thread thread1 = new Thread(task);
        thread1.start();

        // Create and start the second thread
        Thread thread2 = new Thread(task);
        thread2.start();
    }
}