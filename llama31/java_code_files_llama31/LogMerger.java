/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LogMerger {
    public static void mergeLogs(File[] fileArray, File file) throws IOException {
        Event event3;
        Queue[] queueArray = new Queue[fileArray.length];
        for (int i = 0; i < fileArray.length; ++i) {
            queueArray[i] = new ConcurrentLinkedQueue();
        }
        BufferedReader[] bufferedReaderArray = new BufferedReader[fileArray.length];
        for (int i = 0; i < fileArray.length; ++i) {
            bufferedReaderArray[i] = new BufferedReader(new FileReader(fileArray[i]));
        }
        PriorityQueue<Event> priorityQueue = new PriorityQueue<Event>((event, event2) -> Long.compare(event.getTimestamp(), event2.getTimestamp()));
        for (int i = 0; i < fileArray.length; ++i) {
            event3 = LogMerger.readEvent(bufferedReaderArray[i]);
            if (event3 == null) continue;
            queueArray[i].add(event3);
            priorityQueue.add(event3);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        while (!priorityQueue.isEmpty()) {
            int n;
            Event event4;
            event3 = (Event)priorityQueue.poll();
            if (!LogMerger.isDuplicate(event3, bufferedWriter)) {
                bufferedWriter.write(event3.toString());
                bufferedWriter.newLine();
            }
            if ((event4 = LogMerger.readEvent(bufferedReaderArray[n = LogMerger.getLogIndex(event3, fileArray)])) == null) continue;
            queueArray[n].add(event4);
            priorityQueue.add(event4);
        }
        bufferedWriter.close();
    }

    private static Event readEvent(BufferedReader bufferedReader) throws IOException {
        String string = bufferedReader.readLine();
        if (string == null) {
            return null;
        }
        String[] stringArray = string.split(",");
        return new Event(Long.parseLong(stringArray[0]), stringArray[1]);
    }

    private static boolean isDuplicate(Event event, BufferedWriter bufferedWriter) throws IOException {
        return false;
    }

    private static int getLogIndex(Event event, File[] fileArray) {
        return 0;
    }

    public static void main(String[] stringArray) {
        File[] fileArray = new File[]{new File("log1.txt"), new File("log2.txt")};
        File file = new File("output.txt");
        try {
            LogMerger.mergeLogs(fileArray, file);
        }
        catch (IOException iOException) {
            System.err.println("Error merging logs: " + iOException.getMessage());
        }
    }

    private static class Event {
        private long timestamp;
        private String data;

        public Event(long l, String string) {
            this.timestamp = l;
            this.data = string;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public String toString() {
            return this.timestamp + "," + this.data;
        }
    }
}
