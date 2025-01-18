class MyRunnable implements Runnable {
    public void run() {
        // code goes here...
    }
}

// Usage of the 'run' method in a separate thread:
public class MainClass {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();     // JVM will call the 'run' method when ready
    }
}