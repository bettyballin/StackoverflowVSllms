import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;

public class HighPerformanceQueue {
    private ConcurrentSkipListSet<String> queue;
    private FileWriter walWriter;

    public HighPerformanceQueue() throws IOException {
        queue = new ConcurrentSkipListSet<>();
        walWriter = new FileWriter("queue.log", true); // append mode
    }

    public void enqueue(String item) throws IOException {
        queue.add(item);
        // Write to WAL log file
        walWriter.write("ENQUEUE " + item + "\n");
        walWriter.flush();
    }

    public String dequeue() throws IOException {
        String item = queue.pollFirst();
        // Write to WAL log file
        walWriter.write("DEQUEUE " + item + "\n");
        walWriter.flush();
        return item;
    }

    // Restore from backup
    public void restore() throws IOException {
        // Read WAL log file and replay changes
        try (BufferedReader reader = new BufferedReader(new FileReader("queue.log"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ENQUEUE ")) {
                    queue.add(line.substring(8)); // adjusted substring index
                } else if (line.startsWith("DEQUEUE ")) {
                    queue.pollFirst();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            HighPerformanceQueue queue = new HighPerformanceQueue();
            queue.enqueue("item1");
            queue.enqueue("item2");
            System.out.println(queue.dequeue());
            queue.restore();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}