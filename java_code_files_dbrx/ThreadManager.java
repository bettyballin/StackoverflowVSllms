import java.util.HashMap;
import java.util.Map;

class MyThread extends Thread {
    private String id;

    public MyThread(String id) {
        this.id = id;
    }

    public String getIdString() {
        return id;
    }

    @Override
    public void run() {
        // Your task here...
        System.out.println("Thread " + id + " is running...");
    }
}

public class ThreadManager {
    private Map<String, MyThread> threadMap = new HashMap<>();

    public synchronized void start(MyThread thread) {
        if (!threadMap.containsKey(thread.getIdString())) { // check if the thread is already running
            thread.start();
            this.threadMap.put(thread.getIdString(), thread);
        } else {
            System.out.println("The thread " + thread.getIdString() + " is already started.");
        }
    }

    public synchronized void stopThreadWithID(String id) {
        if (this.threadMap.containsKey(id)) { // check if the key exists in your map
            MyThread myThread = this.threadMap.get(id);
            myThread.interrupt(); // This will wake up the thread and tell it that an interrupt request has been made
                                  // but doesn't actually stop the thread immediately. You need to handle interruption inside 'run()'.
        } else {
            System.out.println("The thread " + id + " does not exist.");
        }
    }

    public static void main(String[] args) {
    }
}