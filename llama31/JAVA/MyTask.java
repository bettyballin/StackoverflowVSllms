import java.lang.String;

// Define the ThreadManager class
class ThreadManager {
    private Thread thread;

    public void startThread(String name, Runnable task) {
        thread = new Thread(task);
        thread.setName(name);
        thread.start();
    }

    public void stopThread(String name) {
        if (thread != null && thread.getName().equals(name)) {
            thread.interrupt();
        }
    }
}

public class MyTask implements Runnable {
    @Override
    public void run() {
        // Do some work
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadManager threadManager = new ThreadManager();
        threadManager.startThread("my-thread", new MyTask());
        // Later...
        threadManager.stopThread("my-thread");
    }
}