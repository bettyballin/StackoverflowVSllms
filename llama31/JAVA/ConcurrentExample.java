import java.lang.String;
public class ConcurrentExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Running");
            // Perform some work
            System.out.println("Thread 1: Done");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: Running");
            // Perform some work
            System.out.println("Thread 2: Done");
        });

        thread1.start();
        thread2.start();
    }
}