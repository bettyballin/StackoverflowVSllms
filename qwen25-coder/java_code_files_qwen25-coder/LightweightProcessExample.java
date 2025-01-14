import java.lang.String;
public class LightweightProcessExample {
    public static void main(String[] args) {
        // Creating Thread by extending Thread class
        Thread thread1 = new Thread(() -> {
            System.out.println("This is from thread 1");
        });

        // Creating Thread by implementing Runnable interface
        Runnable runnable = () -> System.out.println("This is from the runnable task assigned to thread 2");
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}