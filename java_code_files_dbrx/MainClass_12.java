import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Task implements Runnable {
    private final String inputFilePath;

    public Task(String filePath) {
        this.inputFilePath = filePath;
    }

    @Override
    public void run() {
        // Your processing logic goes here for each task, using inputFilePath as the task specific data
        // ...
    }
}

public class MainClass {
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("file-list.txt"))) { // Replace with your file input method
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(new Task(line));
            }
        }
        for (Task task : tasks) {
            Thread thread = new Thread(task);
            // You may need to manage and limit the number of threads in case there are too many tasks
            if (threads.size() < MAX_THREADS ) {
                thread.start();
                threads.add(thread);
            } else {
                // This will block until one of the running threads is completed for executing new task
                // Or you can also implement a blocking queue like LinkedBlockingQueue or ArrayBlockingQueue with a thread pool instead
                threads.remove(0).join();
                thread.start();
                threads.add(thread);
            }
        }
        // Wait for all started threads to complete before exiting
        for (Thread t : threads) {
            t.join();
        }
    }
}