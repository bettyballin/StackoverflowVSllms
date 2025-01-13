import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReader {
    public static void main(String[] args) {
        File file = new File("large_file.hex");
        int chunkSize = 10 * 1024 * 1024; // 10MB chunks
        int numThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (long offset = 0; offset < file.length(); offset += chunkSize) {
            long chunkEnd = Math.min(offset + chunkSize, file.length());
            executor.execute(new FileReadingTask(file, offset, chunkEnd));
        }

        executor.shutdown();
    }
}

class FileReadingTask implements Runnable {
    private File file;
    private long offset;
    private long chunkEnd;

    public FileReadingTask(File file, long offset, long chunkEnd) {
        this.file = file;
        this.offset = offset;
        this.chunkEnd = chunkEnd;
    }

    @Override
    public void run() {
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.skip(offset);
            byte[] buffer = new byte[(int) (chunkEnd - offset)];
            fis.read(buffer);

            // Display the read data
            System.out.println("Read chunk from " + offset + " to " + chunkEnd);
            // Process the buffer...
        } catch (IOException e) {
            Thread.currentThread().interrupt();
        }
    }
}