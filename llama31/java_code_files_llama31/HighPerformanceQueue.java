/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;

public class HighPerformanceQueue {
    private ConcurrentSkipListSet<String> queue = new ConcurrentSkipListSet();
    private FileWriter walWriter = new FileWriter("queue.log", true);

    public void enqueue(String string) throws IOException {
        this.queue.add(string);
        this.walWriter.write("ENQUEUE " + string + "\n");
        this.walWriter.flush();
    }

    public String dequeue() throws IOException {
        String string = this.queue.pollFirst();
        this.walWriter.write("DEQUEUE " + string + "\n");
        this.walWriter.flush();
        return string;
    }

    public void restore() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("queue.log"));){
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                if (string.startsWith("ENQUEUE ")) {
                    this.queue.add(string.substring(8));
                    continue;
                }
                if (!string.startsWith("DEQUEUE ")) continue;
                this.queue.pollFirst();
            }
        }
    }

    public static void main(String[] stringArray) {
        try {
            HighPerformanceQueue highPerformanceQueue = new HighPerformanceQueue();
            highPerformanceQueue.enqueue("item1");
            highPerformanceQueue.enqueue("item2");
            System.out.println(highPerformanceQueue.dequeue());
            highPerformanceQueue.restore();
        }
        catch (IOException iOException) {
            System.err.println("Error: " + iOException.getMessage());
        }
    }
}
