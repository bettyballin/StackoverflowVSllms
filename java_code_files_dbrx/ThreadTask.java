import java.lang.String;

public class ThreadTask implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { // Your task here...
            System.out.println("Thread " + Thread.currentThread().getId() + " is running...");
        }
    }

    public static void main(String[] args) {
    }
}