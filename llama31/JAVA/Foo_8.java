// Define a simple Runnable for demonstration purposes
class FooRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted. Stopping...");
                break;
            }
        }
    }
}

// A basic ThreadManager class
import java.util.HashMap;
import java.util.Map;

class ThreadManager {
    private Map<String, Thread> threads = new HashMap<>();
    
    public void addThread(String name, Thread thread) {
        threads.put(name, thread);
    }
    
    public void killThread(String name) {
        Thread thread = threads.get(name);
        if (thread != null) {
            thread.interrupt();
        }
    }
    
    public static ThreadManager instance;
    
    public static ThreadManager getInstance() {
        if (instance == null) {
            instance = new ThreadManager();
        }
        return instance;
    }
}

public class Foo_8_8 {
    public static void main(String[] args) {
        ThreadManager threadManager = ThreadManager.getInstance();
        
        Thread fooT1 = new Thread(new FooRunnable());
        threadManager.addThread("fooT1", fooT1);
        fooT1.start();
    }
}

public class Bar {
    public static void main(String[] args) {
        ThreadManager threadManager = ThreadManager.getInstance();
        
        // Corrected thread name to match the one in Foo_8
        threadManager.killThread("fooT1");
    }
}