import java.lang.String;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HighPerformanceQueue {
    private ArrayDeque<String> queue = new ArrayDeque<>();
    private final Lock lock = new ReentrantLock();
    private static final String BACKUP_PATH = "queue_backup.bin";

    public void enqueue(String item) {
        lock.lock();
        try {
            queue.addFirst(item);
            persistToDisk(); // Persist immediately
        } finally {
            lock.unlock();
        }
    }

    public String dequeue() {
        lock.lock();
        try {
            String item = queue.pollLast();
            persistToDisk(); // Update backup after removal
            return item;
        } finally {
            lock.unlock();
        }
    }

    private void persistToDisk() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BACKUP_PATH))) {
            oos.writeObject(queue);
        } catch (IOException e) {
            System.err.println("Failed to backup queue: " + e.getMessage());
        }
    }

    public void restoreFromDisk() {
        if (Files.exists(Paths.get(BACKUP_PATH))) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BACKUP_PATH))) {
                queue = (ArrayDeque<String>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Failed to restore backup: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        HighPerformanceQueue queueSystem = new HighPerformanceQueue();
        
        // Restore queue from backup if available
        queueSystem.restoreFromDisk();

        // Simulate operations
        queueSystem.enqueue("Task 1");
        queueSystem.enqueue("Task 2");

        System.out.println("Dequeued: " + queueSystem.dequeue());
    }
}