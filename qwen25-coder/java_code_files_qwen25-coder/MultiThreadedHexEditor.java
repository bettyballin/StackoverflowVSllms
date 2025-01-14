import java.lang.String;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MultiThreadedHexEditor {
    public static void main(String[] args) throws Exception {
        String filePath = "largefile.bin";
        int numberOfThreads = 4; // Number of threads to use
        long fileSize = new java.io.File(filePath).length();
        long chunkSize = fileSize / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            final long start = i * chunkSize;
            final long length = (i == numberOfThreads - 1) ? fileSize - start : chunkSize; // Handle last chunk
            threads[i] = new Thread(() -> readAndDisplayChunk(filePath, start, length));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join(); // Wait for all threads to finish
        }
    }

    private static void readAndDisplayChunk(String filePath, long start, long length) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
             FileChannel channel = file.getChannel()) {

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, start, length);
            while (buffer.hasRemaining()) {
                // Display or process each byte
                System.out.print(String.format("%02X ", buffer.get()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}