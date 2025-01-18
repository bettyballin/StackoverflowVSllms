public class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                // This is where you put what the thread should do while running
                System.out.println("Hello from thread: " + this);
            }
        };
        t.start();  // starts a new call stack for 'this' thread
    }
}