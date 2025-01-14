import java.lang.String;
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to execute in a new thread
        System.out.println("Running in a separate thread");
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();
    }
}