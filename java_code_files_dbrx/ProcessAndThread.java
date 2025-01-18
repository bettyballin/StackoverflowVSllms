import java.lang.String;
public class ProcessAndThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main process ID : " + ProcessHandle.current().pid());

        Thread t1 = new Thread(() -> System.out.println("Thread 1 ID: " + ProcessHandle.current().pid()));
        t1.start();
        t1.join(); // Waiting for the thread to finish before exiting main process
    }
}